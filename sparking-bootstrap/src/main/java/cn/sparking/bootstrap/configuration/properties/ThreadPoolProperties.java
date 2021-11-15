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

package cn.sparking.bootstrap.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spk.pool")
public class ThreadPoolProperties {

    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;

    /**
     * Get the value of thread pool size.
     * @return {@link Integer}
     */
    public int getCorePoolSize() {
        return corePoolSize;
    }

    /**
     * Set the thread pool size.
     * @param corePoolSize {@link Integer}
     */
    public void setCorePoolSize(final int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    /**
     * Get the value of redis host.
     * @return {@link Integer}
     */
    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    /**
     * Set the thread pool max pool size.
     * @param maxPoolSize {@link Integer}
     */
    public void setMaxPoolSize(final int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    /**
     * Get the value of KeepAliveSeconds.
     * @return {@link Integer}
     */
    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    /**
     * Set the thread pool keep alive seconds.
     * @param keepAliveSeconds {@link Integer}
     */
    public void setKeepAliveSeconds(final int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    /**
     * Get the value of thread pool queueCapacity.
     * @return {@link Integer}
     */
    public int getQueueCapacity() {
        return queueCapacity;
    }

    /**
     * Set the thread pool queue capacity.
     * @param queueCapacity {@link Integer}
     */
    public void setQueueCapacity(final int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }
}
