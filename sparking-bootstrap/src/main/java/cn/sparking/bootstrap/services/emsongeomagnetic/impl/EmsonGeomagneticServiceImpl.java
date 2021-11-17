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

import cn.sparking.bootstrap.result.emsongeomagnetic.EmsonGeomagneticResponse;
import cn.sparking.bootstrap.services.emsongeomagnetic.EmsonGeomagneticService;
import cn.sparking.common.constant.EmsonGeomagneticConstants;
import cn.sparking.common.exception.SparkingException;
import cn.sparking.core.pattern.AdaptedService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmsonGeomagneticServiceImpl implements EmsonGeomagneticService {

    private static final Logger LOG = LoggerFactory.getLogger(EmsonGeomagneticServiceImpl.class);

    private final AdaptedService emsonGeomagneticAdapterService;

    public EmsonGeomagneticServiceImpl(final AdaptedService emsonGeomagneticAdapterService) {
        this.emsonGeomagneticAdapterService = emsonGeomagneticAdapterService;
    }

    /**
     * deal EmsonGeomagnetic processApi.
     * @param jsonObject request obj
     * @return {@link EmsonGeomagneticResponse}
     */
    @Override
    public EmsonGeomagneticResponse processApi(final JSONObject jsonObject) {

        try {

            if (ObjectUtils.notEqual(jsonObject, ObjectUtils.NULL)
                    && jsonObject.containsKey(EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_REQUEST_CMD)) {
                return null;
            }

        } catch (SparkingException e) {
            LOG.error(EmsonGeomagneticConstants.EMSON_GEOMAGNETIC_FLAG + " processApi Error: " + e);
        }

        return null;
    }
}
