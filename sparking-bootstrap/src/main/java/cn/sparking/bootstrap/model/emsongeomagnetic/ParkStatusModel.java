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
 * Park Status Model.
 */
public class ParkStatusModel implements Serializable {

    private static final long serialVersionUID = 6240827859689786159L;

    /**
     * 指令编码.
     */
    private String cmd;

    /**
     * 停车场编号.
     */
    private Integer parkID;

    /**
     * yyyyMMddhhmmss.
     */
    private String time;

    /**
     * 设备ID.
     */
    private String deviceID;

    /**
     * 信号强度.
     */
    private Integer rssi;

    /**
     * 过去时间.
     */
    private Integer passTime;

    /**
     * 序号.
     */
    private Integer sequence;

    /**
     * 电量.
     */
    private Integer battary;

    /**
     * 占用状态.
     */
    private Integer parkingStatu;

    /**
     * 校验和.
     */
    private String token;

    /**
     * Get cmd.
     * @return the cmd
     */
    public String getCmd() {
        return cmd;
    }

    /**
     * Get parkingId.
     * @return the parking id
     */
    public Integer getParkID() {
        return parkID;
    }

    /**
     * Get time.
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Get device id.
     * @return the device id
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * Get rssi.
     * @return the rssi
     */
    public Integer getRssi() {
        return rssi;
    }

    /**
     * Get pass time.
     * @return the pass time
     */
    public Integer getPassTime() {
        return passTime;
    }

    /**
     * Get sequence.
     * @return the sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * Get battary.
     * @return the battary
     */
    public Integer getBattary() {
        return battary;
    }

    /**
     * Get parking status.
     * @return the parking status
     */
    public Integer getParkingStatu() {
        return parkingStatu;
    }

    /**
     * Get token.
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Set cmd.
     * @param cmd the cmd
     */
    public void setCmd(final String cmd) {
        this.cmd = cmd;
    }

    /**
     * Set park id.
     * @param parkID the parkID
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
     * @param deviceID the device ID.
     */
    public void setDeviceID(final String deviceID) {
        this.deviceID = deviceID;
    }

    /**
     * Set rssi.
     * @param rssi the rssi
     */
    public void setRssi(final Integer rssi) {
        this.rssi = rssi;
    }

    /**
     * Set pass time.
     * @param passTime the pass Time
     */
    public void setPassTime(final Integer passTime) {
        this.passTime = passTime;
    }

    /**
     * Set sequence.
     * @param sequence the sequence
     */
    public void setSequence(final Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * Set battary.
     * @param battary the battary
     */
    public void setBattary(final Integer battary) {
        this.battary = battary;
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
}
