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

package cn.sparking.core.factory;

import cn.sparking.core.pattern.AdaptedService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Adapted Factory.
 */
@Component(value = "AdaptedFactory")
public class AdaptedFactory implements ApplicationContextAware {

    private static Map<String, AdaptedService> adaptedServiceMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        applicationContext.getBeansOfType(AdaptedService.class).values().forEach(adapted -> {
            Class<? extends AdaptedService> adaptedServiceClass = adapted.getClass();
            adaptedServiceMap.put(adaptedServiceClass.getSimpleName(), adapted);
        });
    }

    /**
     * get adapted service.
     * @param beanName adapted bean name
     * @return {@link AdaptedService}
     */
    public static AdaptedService getAdaptedService(final String beanName) {
        return adaptedServiceMap.get(beanName);
    }
}
