package com.jialong.powersite.modular.system.model;

public class JlDeviceStatus {
	   
    private  long id;
     
	 //设备名称
    private  long deviceId;

    private  String status;

    private  long auditor;

    private  String addTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getAuditor() {
        return auditor;
    }

    public void setAuditor(long auditor) {
        this.auditor = auditor;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}