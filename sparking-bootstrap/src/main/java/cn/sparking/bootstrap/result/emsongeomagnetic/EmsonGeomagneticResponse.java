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

package cn.sparking.bootstrap.result.emsongeomagnetic;

import java.io.Serializable;

/**
 * EmsonGeomagneticResult.
 */
public class EmsonGeomagneticResponse implements Serializable {

    private static final long serialVersionUID = -7929905678236987979L;

    /**
     * 状态码.
     */
    private Integer code;

    /**
     * 消息体.
     */
    private Body body;

    EmsonGeomagneticResponse() {

    }

    /**
     * Get code.
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Set code.
     * @param code the code
     */
    public void setCode(final Integer code) {
        this.code = code;
    }

    /**
     * Get code.
     * @return the code
     */
    public Body getBody() {
        return body;
    }

    /**
     * Set code.
     * @param body {@link Body}
     */
    public void setBody(final Body body) {
        this.body = body;
    }

    /**
     * Body.
     */
    public static final class Body {

        /**
         * msg.
         */
        private String msg;

        /**
         * Get msg.
         * @return the msg
         */
        public String getMsg() {
            return msg;
        }

        /**
         * Set msg.
         * @param msg the msg
         */
        public void setMsg(final String msg) {
            this.msg = msg;
        }
    }
}
