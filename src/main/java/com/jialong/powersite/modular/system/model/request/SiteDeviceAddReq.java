package com.jialong.powersite.modular.system.model.request;

public class SiteDeviceAddReq {

    //站房id
    private  Integer siteId;

    //设备id
    private  Integer deviceId;

    private  Integer auditor;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getAuditor() {
        return auditor;
    }

    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
    }
}
