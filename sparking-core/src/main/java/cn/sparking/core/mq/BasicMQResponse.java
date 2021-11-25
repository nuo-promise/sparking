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

package cn.sparking.core.mq;

import cn.sparking.common.exception.CommonErrorCode;

import java.io.Serializable;

/**
 * MQ Response.
 */
public class BasicMQResponse implements Serializable {

    private static final long serialVersionUID = -6332249143816513665L;

    private String code;

    private String msg;

    public BasicMQResponse() {
        code = CommonErrorCode.MQ_SUCCESS;
    }

    public BasicMQResponse(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Get code.
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * set code.
     * @param code the code
     */
    public void setCode(final String code) {
        this.code = code;
    }

    /**
     * get msg.
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * set msg.
     * @param msg the msg
     */
    public void setMsg(final String msg) {
        this.msg = msg;
    }
}
