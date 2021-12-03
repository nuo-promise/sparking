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

package cn.sparking.common.utils;

import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveRedisUtils {

    private static final ReactiveRedisTemplate<String, Object> REDISTEMPLATE = SpringBootUtils.getBean("ReactiveRedisTemplate", ReactiveRedisTemplate.class);

    /**
     * putData.
     * @param key the key
     * @param value the value
     * @return {@link Mono}
     */
    public static Mono<Boolean> putValue(final String key, final Object value) {
        ReactiveValueOperations<String, Object> reactiveValueOps = REDISTEMPLATE.opsForValue();
        return reactiveValueOps.set(key, value);
    }

    /**
     * put data and expiry time.
     * @param key the key
     * @param value the value
     * @param time time
     * @return {@link Mono}
     */
    public static Mono<Boolean> putValue(final String key, final Object value, final int time) {
        ReactiveValueOperations<String, Object> reactiveValueOps = REDISTEMPLATE.opsForValue();
        return reactiveValueOps.set(key, value, Duration.ofSeconds(time));
    }

    /**
     * get value by key.
     * @param key the key
     * @return {@link Mono}
     */
    public static Mono<Object> getData(final String key) {
        ReactiveValueOperations<String, Object> reactiveValueOps = REDISTEMPLATE.opsForValue();
        return reactiveValueOps.get(key);
    }
}
