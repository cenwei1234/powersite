package com.jialong.powersite.modular.system.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jialong.powersite.core.utils.Page;
import com.jialong.powersite.modular.system.model.JlAlarmLog;

import java.util.Date;


public class AlarmLogListReq extends Page<JlAlarmLog>{

    private  Integer noticeType;

    private  String alarmDetail;

    private  String alarmTimeBegin;

    private  String alarmTimeEnd;

    private  Integer siteId;

    private Integer alarmLevel;

    private String TriggerValue;

    private Integer alarmDevice;

    private Integer siteType;

    private  Integer auditor;

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

    public String getAlarmTimeBegin() {
        return alarmTimeBegin;
    }

    public void setAlarmTimeBegin(String alarmTimeBegin) {
        this.alarmTimeBegin = alarmTimeBegin;
    }

    public String getAlarmTimeEnd() {
        return alarmTimeEnd;
    }

    public void setAlarmTimeEnd(String alarmTimeEnd) {
        this.alarmTimeEnd = alarmTimeEnd;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getAuditor() {
        return auditor;
    }

    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
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

    public Integer getSiteType() {
        return siteType;
    }

    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }
}
