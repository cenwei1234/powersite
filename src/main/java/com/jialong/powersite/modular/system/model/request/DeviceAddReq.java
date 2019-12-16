package com.jialong.powersite.modular.system.model.request;

public class DeviceAddReq {

    //设备id
    private  String deviceName;

    private  Integer auditor;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getAuditor() {
        return auditor;
    }

    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
    }
}
