package com.jialong.powersite.modular.system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddDeviceOperationListData;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddParamData;

import java.util.List;

public class SiteOperationAddDeviceData {

    @JsonProperty(value = "deviceType")
    private Integer deviceId;

    private String deviceName;

    private Boolean deviceStatus;

    private Boolean deviceOperatable;

    private List<Integer> deviceOperation;

    private List<SiteOperationAddParamData> paramDataList;

    private List<SiteOperationAddDeviceOperationListData> operationList;

    public List<SiteOperationAddDeviceOperationListData> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<SiteOperationAddDeviceOperationListData> operationList) {
        this.operationList = operationList;
    }

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

    public Boolean getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Boolean deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public List<SiteOperationAddParamData> getParamDataList() {
        return paramDataList;
    }

    public void setParamDataList(List<SiteOperationAddParamData> paramDataList) {
        this.paramDataList = paramDataList;
    }

    public Boolean getDeviceOperatable() {
        return deviceOperatable;
    }

    public void setDeviceOperatable(Boolean deviceOperatable) {
        this.deviceOperatable = deviceOperatable;
    }

    public List<Integer> getDeviceOperation() {
        return deviceOperation;
    }

    public void setDeviceOperation(List<Integer> deviceOperation) {
        this.deviceOperation = deviceOperation;
    }
}
