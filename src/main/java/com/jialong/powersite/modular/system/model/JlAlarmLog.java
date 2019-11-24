package com.jialong.powersite.modular.system.model;

import java.util.Date;

public class JlAlarmLog {

    private  long id;

    private  long noticeType;

    private  String alarmDetail;

    private Date alarmTime;

    private  long siteId;

    private  long auditor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(long noticeType) {
        this.noticeType = noticeType;
    }

    public String getAlarmDetail() {
        return alarmDetail;
    }

    public void setAlarmDetail(String alarmDetail) {
        this.alarmDetail = alarmDetail;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public long getAuditor() {
        return auditor;
    }

    public void setAuditor(long auditor) {
        this.auditor = auditor;
    }

    @Override
    public String toString() {
        return "JlAlarmLog{" +
                "id=" + id +
                ", noticeType=" + noticeType +
                ", alarmDetail='" + alarmDetail + '\'' +
                ", alarmTime=" + alarmTime +
                ", siteId=" + siteId +
                ", auditor=" + auditor +
                '}';
    }
}