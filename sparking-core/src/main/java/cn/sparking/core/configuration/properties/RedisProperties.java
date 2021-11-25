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

/**
 * Cloud Redis Configuration.
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private String host;

    private int port;

    private String password;

    private int database;

    private int timeout;

    /**
     * Get the value of redis host.
     * @return {@link Integer}
     */
    public String getHost() {
        return host;
    }

    /**
     * Set the redis host.
     * @param host {@link String}
     */
    public void setHost(final String host) {
        this.host = host;
    }

    /**
     * Get the value of redis port.
     * @return {@link Integer}
     */
    public int getPort() {
        return port;
    }

    /**
     * Set the redis port.
     * @param port {@link Integer}
     */
    public void setPort(final int port) {
        this.port = port;
    }

    /**
     * Get the value of redis password.
     * @return {@link Integer}
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the redis password.
     * @param password {@link String}
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Get the value of database.
     * @return {@link Integer}
     */
    public int getDatabase() {
        return database;
    }

    /**
     * Set the redis database.
     * @param database {@link String}
     */
    public void setDatabase(final int database) {
        this.database = database;
    }

    /**
     * Get the value of timeout.
     * @return {@link Integer}
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Set the redis connect timeout.
     * @param timeout {@link Integer}
     */
    public void setTimeout(final int timeout) {
        this.timeout = timeout;
    }
}
