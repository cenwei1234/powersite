package com.jialong.powersite.modular.system.model;

public class JlAlarmLog {

    private  Integer id;

    private  Integer siteId;

    private  Integer noticeType;

    private  String alarmDetail;

    private Integer alarmLevel;

    private Integer siteType;

    private String TriggerValue;

    private Integer alarmDevice;

    private String alarmTime;

    private  Integer auditor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public String getAlarmDetail() {
        return alarmDetail;
    }

    public void setAlarmDetail(String alarmDetail) {
        this.alarmDetail = alarmDetail;
    }

    public Integer getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(Integer alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public String getTriggerValue() {
        return TriggerValue;
    }

    public void setTriggerValue(String triggerValue) {
        TriggerValue = triggerValue;
    }

    public Integer getAlarmDevice() {
        return alarmDevice;
    }

    public void setAlarmDevice(Integer alarmDevice) {
        this.alarmDevice = alarmDevice;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Integer getAuditor() {
        return auditor;
    }

    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
    }

    public Integer getSiteType() {
        return siteType;
    }

    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }
}