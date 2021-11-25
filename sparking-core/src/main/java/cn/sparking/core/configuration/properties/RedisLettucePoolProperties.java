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

package cn.sparking.core.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.redis.lettuce.pool")
public class RedisLettucePoolProperties {

    private Integer maxActive;

    private Integer maxIdle;

    private Integer minIdle;

    private Integer maxWait;

    /**
     * Get the value of max active.
     * @return {@link Integer}
     */
    public Integer getMaxActive() {
        return maxActive;
    }

    /**
     * Set the max Active.
     * @param maxActive {@link Integer}
     */
    public void setMaxActive(final Integer maxActive) {
        this.maxActive = maxActive;
    }

    /**
     * Get the value of max idle.
     * @return {@link Integer}
     */
    public Integer getMaxIdle() {
        return maxIdle;
    }

    /**
     * Set the max Idle.
     * @param maxIdle {@link Integer}
     */
    public void setMaxIdle(final Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    /**
     * Get the value of min idle.
     * @return {@link Integer}
     */
    public Integer getMinIdle() {
        return minIdle;
    }

    /**
     * Set the min idle.
     * @param minIdle {@link Integer}
     */
    public void setMinIdle(final Integer minIdle) {
        this.minIdle = minIdle;
    }

    /**
     * Get the value of max wait.
     * @return {@link Integer}
     */
    public Integer getMaxWait() {
        return maxWait;
    }

    /**
     * Set the max wait.
     * @param maxWait {@link Integer}
     */
    public void setMaxWait(final Integer maxWait) {
        this.maxWait = maxWait;
    }
}
