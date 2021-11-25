/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.sparking.bootstrap.services.emsongeomagnetic.impl;

import cn.sparking.bootstrap.model.emsongeomagnetic.EmsonGeomagneticRequest;
import cn.sparking.bootstrap.result.emsongeomagnetic.EmsonGeomagneticResponse;
import cn.sparking.bootstrap.services.emsongeomagnetic.EmsonGeomagneticService;
import cn.sparking.common.constant.EmsonGeomagneticConstants;
import cn.sparking.common.exception.SparkingException;
import cn.sparking.bootstrap.model.emsongeomagnetic.HeartModel;
import cn.sparking.bootstrap.model.emsongeomagnetic.ParkStatusModel;
import cn.sparking.bootstrap.model.emsongeomagnetic.RegisterModel;
import cn.sparking.bootstrap.services.emsongeomagnetic.EmsonGeomagneticProducer;
import cn.sparking.core.factory.AdaptedFactory;
import cn.sparking.core.pattern.AdaptedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Optional;

/**
 * Emson Geomagnetic service.
 */
@Service("EmsonGeomagneticServiceImpl")
public class EmsonGeomagneticServiceImpl implements EmsonGeomagneticService {

    private static final Logger LOG = LoggerFactory.getLogger(EmsonGeomagneticServiceImpl.class);

    private final AdaptedFactory adaptedFactory;

    public EmsonGeomagneticServiceImpl(final AdaptedService emsonGeomagneticAdapterService,
                                       final EmsonGeomagneticProducer emsonGeomagneticProducer, AdaptedFactory adaptedFactory) {
        this.adaptedFactory = adaptedFactory;
    }

    /**
     * deal EmsonGeomagnetic processApi.
     * @param emasonRequest request obj
     * @return {@link EmsonGeomagneticResponse}
     */
    @Override
    public EmsonGeomagneticResponse processApi(final EmsonGeomagneticRequest<Object> emasonRequest) {

        try {
            if (!invoke(emasonRequest)) {
                return new EmsonGeomagneticResponse(EmsonGeomagneticConstants.EMSON_ERROR_101, new EmsonGeomagneticResponse.Body(EmsonGeomagneticConstants.EMSON_ERROR_101_MSG));
            }
            adaptedFactory.getAdaptedService(EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_ADAPTER_SERVICE).adapted(emasonRequest);
        } catch (SparkingException e) {
            LOG.error(EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_FLAG + " processApi Error: " + e);
        }
        return null;
    }

    /**
     * invoke redis process.
     * @param emasonRequest {@link EmsonGeomagneticRequest}
     */
    private boolean invoke(final EmsonGeomagneticRequest<Object> emasonRequest) {
        if (Optional.ofNullable(emasonRequest).isPresent()) {
            switch (emasonRequest.getCmd()) {
                case EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_REGISTER:
                    return validRegisterData(emasonRequest.getCmd(), (RegisterModel) emasonRequest.getBody());
                case EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_HEART:
                    return validHeartBeatData(emasonRequest.getCmd(), (HeartModel) emasonRequest.getBody());
                case EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_STATUS:
                    return validParkStatusData(emasonRequest.getCmd(), (ParkStatusModel) emasonRequest.getBody());
                default:
                    LOG.warn("EMSON CMD: " + emasonRequest.getCmd() + " Have Not Match");
                    break;
            }
        }
        return false;
    }

    /**
     * valid RegisterModel data.
     * @param registerModel {@link RegisterModel}
     * @return boolean
     */
    private boolean validRegisterData(final String cmd, final RegisterModel registerModel) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cmd);
        stringBuilder.append(registerModel.getParkID());
        stringBuilder.append(registerModel.getTime());
        stringBuilder.append(registerModel.getDeviceID());
        stringBuilder.append(registerModel.getVersion());
        LOG.info("validRegister Before: " + stringBuilder);
        return md5(stringBuilder.toString(), registerModel.getToken());
    }

    /**
     * valid HeartModel data.
     * @param heartModel {@link HeartModel}
     * @return boolean
     */
    private boolean validHeartBeatData(final String cmd, final HeartModel heartModel) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cmd);
        stringBuilder.append(heartModel.getParkID());
        stringBuilder.append(heartModel.getTime());
        stringBuilder.append(heartModel.getDeviceID());
        stringBuilder.append(heartModel.getBattary());
        stringBuilder.append(heartModel.getErrcode());
        stringBuilder.append(heartModel.getSnr());
        stringBuilder.append(heartModel.getRsrp());
        stringBuilder.append(heartModel.getParkingStatu());
        LOG.info("validHeartBeat Before: " + stringBuilder);
        return md5(stringBuilder.toString(), heartModel.getToken());
    }

    /**
     * valid ParkStatusModel data.
     * @param parkStatusModel {@link ParkStatusModel}
     * @return boolean
     */
    private boolean validParkStatusData(final String cmd, final ParkStatusModel parkStatusModel) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cmd);
        stringBuilder.append(parkStatusModel.getParkID());
        stringBuilder.append(parkStatusModel.getTime());
        stringBuilder.append(parkStatusModel.getDeviceID());
        stringBuilder.append(parkStatusModel.getRssi());
        stringBuilder.append(parkStatusModel.getPassTime());
        stringBuilder.append(parkStatusModel.getSequence());
        stringBuilder.append(parkStatusModel.getBattary());
        stringBuilder.append(parkStatusModel.getParkingStatu());
        LOG.info("validParkStatus Before: " + stringBuilder);
        return md5(stringBuilder.toString(), parkStatusModel.getToken());
    }

    /**
     * MD5.
     * @param data the data
     * @param token the token
     * @return boolean
     */
    private boolean md5(final String data, final String token) {
        String keyStr = DigestUtils.md5Hex(data.toUpperCase()).toUpperCase();
        LOG.info("MD5 Value: " + keyStr);
        if (keyStr.equals(token)) {
            return true;
        } else {
            LOG.warn("Current MD5 :" + keyStr + ", Data Token : " + token);
        }
        return false;
    }
}
