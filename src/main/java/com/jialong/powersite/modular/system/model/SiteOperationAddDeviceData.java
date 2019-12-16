package com.jialong.powersite.modular.system.model;

import com.jialong.powersite.modular.system.model.request.SiteOperationAddParamData;

import java.util.List;

public class SiteOperationAddDeviceData {

    private Integer deviceId;

    private String deviceName;

    private Integer deviceStatus;

    private Integer deviceType;

    private List<SiteOperationAddParamData> paramDataList;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public List<SiteOperationAddParamData> getParamDataList() {
        return paramDataList;
    }

    public void setParamDataList(List<SiteOperationAddParamData> paramDataList) {
        this.paramDataList = paramDataList;
    }
}
