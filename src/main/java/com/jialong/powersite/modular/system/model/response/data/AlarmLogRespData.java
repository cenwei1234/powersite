package com.jialong.powersite.modular.system.model.response.data;

public class AlarmLogRespData {

    private  Integer id;

    private  Integer noticeType;

    private  String alarmDetail;

    private Integer alarmLevel;

    private Integer siteType;

    private String TriggerValue;

    private Integer alarmDevice;

    private Integer alarmParam;

    private String alarmTime;

    private  String siteName;

    private  String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSiteType() {
        return siteType;
    }

    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
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

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAlarmParam() {
        return alarmParam;
    }

    public void setAlarmParam(Integer alarmParam) {
        this.alarmParam = alarmParam;
    }
}