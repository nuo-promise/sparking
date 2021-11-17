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

package cn.sparking.bootstrap.model.emsongeomagnetic;

import java.io.Serializable;

/**
 * Heart Data Model.
 */
public class HeartModel implements Serializable {

    private static final long serialVersionUID = 5673277872922057503L;

    /**
     * 指令编码.
     */
    private String cmd;

    /**
     * 停车场编号.
     */
    private Integer parkID;

    /**
     * 车位状态变化时间.
     */
    private String time;

    /**
     * 设备ID.
     */
    private String deviceID;

    /**
     * 信号强度.
     */
    private Integer battary;

    /**
     * 过去时间.
     */
    private Integer errcode;

    /**
     * 序号.
     */
    private Integer snr;

    /**
     * 电量.
     */
    private Integer rsrp;

    /**
     * 占用状态.
     */
    private Integer parkingStatu;

    /**
     * 校验和.
     */
    private String token;

    HeartModel() {

    }
    /**
     * get cmd.
     * @return the cmd
     */
    public String getCmd() {
        return cmd;
    }

    /**
     * get park id.
     * @return the park id
     */
    public Integer getParkID() {
        return parkID;
    }

    /**
     * get time.
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * get device id.
     * @return the device id
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * get battary.
     * @return the battary
     */
    public Integer getBattary() {
        return battary;
    }

    /**
     * get errcode.
     * @return the errcode
     */
    public Integer getErrcode() {
        return errcode;
    }

    /**
     * get  snr.
     * @return the snr
     */
    public Integer getSnr() {
        return snr;
    }

    /**
     * get rsrp.
     * @return the rsrp
     */
    public Integer getRsrp() {
        return rsrp;
    }

    /**
     * get parking status.
     * @return the parking status
     */
    public Integer getParkingStatu() {
        return parkingStatu;
    }

    /**
     * get token.
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Set park id.
     * @param parkID the park id
     */
    public void setParkID(final Integer parkID) {
        this.parkID = parkID;
    }

    /**
     * Set time.
     * @param time the time
     */
    public void setTime(final String time) {
        this.time = time;
    }

    /**
     * Set device id.
     * @param deviceID the device id
     */
    public void setDeviceID(final String deviceID) {
        this.deviceID = deviceID;
    }

    /**
     * Set battary.
     * @param battary the battary
     */
    public void setBattary(final Integer battary) {
        this.battary = battary;
    }

    /**
     * Set errcode.
     * @param errcode the errcode
     */
    public void setErrcode(final Integer errcode) {
        this.errcode = errcode;
    }

    /**
     * Set snr.
     * @param snr the snr
     */
    public void setSnr(final Integer snr) {
        this.snr = snr;
    }

    /**
     * Set rsrp.
     * @param rsrp the rsrp
     */
    public void setRsrp(final Integer rsrp) {
        this.rsrp = rsrp;
    }

    /**
     * Set parking status.
     * @param parkingStatu the parking status
     */
    public void setParkingStatu(final Integer parkingStatu) {
        this.parkingStatu = parkingStatu;
    }

    /**
     * Set token.
     * @param token the token
     */
    public void setToken(final String token) {
        this.token = token;
    }

    /**
     * Set cmd.
     * @param cmd the cmd
     */
    public void setCmd(final String cmd) {
        this.cmd = cmd;
    }
}
