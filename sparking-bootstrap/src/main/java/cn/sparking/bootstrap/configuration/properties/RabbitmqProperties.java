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

/**
 * Cloud MQ configuration.
 */
@Component
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitmqProperties {

    private String host;

    private int port;

    private String userName;

    private String passWord;

    private String exchange;

    private Boolean enable;

    /**
     * Gets the value of host.
     * @return the value of host
     */
    public String getHost() {
        return host;
    }

    /**
     * Set the host.
     * @param host {@linkplain String}
     */
    public void setHost(final String host) {
        this.host = host;
    }

    /**
     * Get the value of port.
     * @return the value of port
     */
    public int getPort() {
        return port;
    }

    /**
     * Set the port.
     * @param port {@linkplain int}
     */
    public void setPort(final int port) {
        this.port = port;
    }

    /**
     * Get the value of userName.
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the userName.
     * @param userName {@linkplain String}
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * Get the value of password.
     * @return the value of password
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * Set the passWord.
     * @param passWord {@linkplain String}
     */
    public void setPassWord(final String passWord) {
        this.passWord = passWord;
    }

    /**
     * Get the value of exchange.
     * @return the value of exchange
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * Set the exchange.
     * @param exchange {@linkplain String}
     */
    public void setExchange(final String exchange) {
        this.exchange = exchange;
    }

    /**
     * Get the value of enable.
     * @return the value of enable
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * Set to enable.
     * @param enable {@linkplain Boolean}
     */
    public void setEnable(final Boolean enable) {
        this.enable = enable;
    }
}
