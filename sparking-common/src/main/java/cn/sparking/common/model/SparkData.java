package cn.sparking.common.model;

import java.io.Serializable;

public class SparkData implements Serializable {

    private static final long serialVersionUID = -6608965558272969604L;

    /**
     * 唯一ID.
     */
    private String id;

    /**
     * 设备状态.
     */
    private String deviceStatus;

    /**
     * 车位状态.
     */
    private String parkStatus;

    /**
     * 更新时间.
     */
    private String updateTime;

    public SparkData(final String id, final String deviceStatus, final String parkStatus, final String updateTime) {
        this.id = id;
        this.deviceStatus = deviceStatus;
        this.parkStatus = parkStatus;
        this.updateTime = updateTime;
    }

    /**
     * Get Id.
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Set Id.
     * @param id the id
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Get DeviceStatus.
     * @return String
     */
    public String getDeviceStatus() {
        return deviceStatus;
    }

    /**
     * Set deviceStatus.
     * @param deviceStatus the deviceStatus
     */
    public void setDeviceStatus(final String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    /**
     * Get ParkStatus.
     * @return String
     */
    public String getParkStatus() {
        return parkStatus;
    }

    /**
     * Set parkStatus.
     * @param parkStatus the parkStatus
     */
    public void setParkStatus(final String parkStatus) {
        this.parkStatus = parkStatus;
    }

    /**
     * Get UpdateTime.
     * @return String
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * Set updateTime.
     * @param updateTime the updateTime
     */
    public void setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
    }
}
