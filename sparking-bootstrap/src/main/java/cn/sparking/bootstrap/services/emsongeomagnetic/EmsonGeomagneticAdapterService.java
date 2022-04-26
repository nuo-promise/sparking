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

package cn.sparking.bootstrap.services.emsongeomagnetic;

import cn.sparking.bootstrap.model.emsongeomagnetic.EmsonGeomagneticRequest;
import cn.sparking.bootstrap.model.emsongeomagnetic.HeartModel;
import cn.sparking.bootstrap.model.emsongeomagnetic.ParkStatusModel;
import cn.sparking.bootstrap.model.emsongeomagnetic.RegisterModel;
import cn.sparking.common.constant.EmsonGeomagneticConstants;
import cn.sparking.common.exception.SparkingException;
import cn.sparking.common.model.SparkData;
import cn.sparking.common.utils.DateTimeUtils;
import cn.sparking.common.utils.ReactiveRedisUtils;
import cn.sparking.core.pattern.AdaptedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * EmsonGeomagneticAdapterService.
 */
@Service
public class EmsonGeomagneticAdapterService extends AdaptedService {

    /**
     * Redis Value expired 600s.
     */
    private static final int REDIS_EXPIRED_INTERVAL = 600;

    private static final Logger LOG = LoggerFactory.getLogger(EmsonGeomagneticAdapterService.class);

    private final EmsonGeomagneticProducer emsonGeomagneticProducer;

    EmsonGeomagneticAdapterService(final EmsonGeomagneticProducer emsonGeomagneticProducer) {
        super(EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_ADAPTER_SERVICE);
        this.emsonGeomagneticProducer = emsonGeomagneticProducer;
    }

    @Override
    public void adapted(final Object parameters) {

        try {
            EmsonGeomagneticRequest<Object> emasonRequest = (EmsonGeomagneticRequest<Object>) parameters;
            if (Optional.ofNullable(emasonRequest).isPresent()) {
                switch (emasonRequest.getCmd()) {
                    case EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_REGISTER:
                        RegisterModel registerModel = (RegisterModel) emasonRequest.getBody();
                        /**
                         * save redis.
                         */
                        opsValue(new SparkData(registerModel.getParkID() + "-" + registerModel.getDeviceID(),
                                EmsonGeomagneticConstants.EMSON_DEVICE_ONLINE,
                                EmsonGeomagneticConstants.SPARK_PARK_STATUS_FREE, DateTimeUtils.timestamp()));
                        /**
                         * producer mq
                         */
                        emsonGeomagneticProducer.publishRegister(registerModel);
                        break;
                    case EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_HEART:
                        HeartModel heartModel = (HeartModel) emasonRequest.getBody();
                        opsHeartValue(heartModel);
                        break;
                    case EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_STATUS:
                        ParkStatusModel parkStatusModel = (ParkStatusModel) emasonRequest.getBody();

                        opsValue(new SparkData(parkStatusModel.getParkID() + "-" + parkStatusModel.getDeviceID(), EmsonGeomagneticConstants.EMSON_DEVICE_ONLINE,
                                parkStatusModel.getParkingStatu() == 0 ? EmsonGeomagneticConstants.SPARK_PARK_STATUS_FREE : EmsonGeomagneticConstants.SPARK_PARK_STATUS_NO_FREE, DateTimeUtils.timestamp()));

                        emsonGeomagneticProducer.publishParkStatus(parkStatusModel);
                        break;
                    default:
                        LOG.warn("EMSON CMD: " + emasonRequest.getCmd() + " Have Not Match");
                        break;
                }
            }
        } catch (SparkingException e) {
            LOG.error(EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_FLAG + " processApi Error: " + e);
        }
    }

    @Override
    public void antiAdapted(final Object parameters) {
    }

    /**
     * ops register value.
     * @param heartModel {@link HeartModel}
     */
    private void opsHeartValue(final HeartModel heartModel) {
        if (Optional.ofNullable(heartModel).isPresent()) {
            if (heartModel.getErrcode() == 0) {
                opsValue(new SparkData(heartModel.getParkID() + "-" + heartModel.getDeviceID(), EmsonGeomagneticConstants.EMSON_DEVICE_ONLINE,
                       heartModel.getParkingStatu() == 0 ? EmsonGeomagneticConstants.SPARK_PARK_STATUS_FREE : EmsonGeomagneticConstants.SPARK_PARK_STATUS_NO_FREE, DateTimeUtils.timestamp()));
                emsonGeomagneticProducer.publishHeartbeat(heartModel);
            } else {
                opsValue(new SparkData(heartModel.getParkID() + "-" + heartModel.getDeviceID(), EmsonGeomagneticConstants.EMSON_DEVICE_OFFLINE,
                        heartModel.getParkingStatu() == 0 ? EmsonGeomagneticConstants.SPARK_PARK_STATUS_FREE : EmsonGeomagneticConstants.SPARK_PARK_STATUS_NO_FREE, DateTimeUtils.timestamp()));
                emsonGeomagneticProducer.publishErrorDevice(heartModel);
            }
        }
    }

    /**
     * save data.
     * @param sparkData {@link SparkData}
     */
    private void opsValue(final SparkData sparkData) {
        ReactiveRedisUtils.putValue(sparkData.getId(), sparkData, REDIS_EXPIRED_INTERVAL).subscribe(
            flag -> {
                if (flag) {
                    LOG.info("Key= " + sparkData.getId() + " save redis success!");
                } else {
                    LOG.info("Key= " + sparkData.getId() + " save redis failed!");
                }
            }
        );
    }
}
