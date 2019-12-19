package com.jialong.powersite.modular.system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddParamData;
import com.jialong.powersite.modular.system.model.response.data.SiteOperationListParamData;

import java.util.List;

public class SiteOperationListDeviceData {

    private Integer deviceType;

    private String deviceName;

    private Integer deviceStatus;

    private List<SiteOperationListParamData> paramDataList;

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
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

    public List<SiteOperationListParamData> getParamDataList() {
        return paramDataList;
    }

    public void setParamDataList(List<SiteOperationListParamData> paramDataList) {
        this.paramDataList = paramDataList;
    }
}
