package com.jialong.powersite.modular.system.model.request;

import com.jialong.powersite.core.utils.Page;
import com.jialong.powersite.modular.system.model.JlAlarmLog;

import java.util.Date;


public class AlarmLogListReq extends Page<JlAlarmLog>{

    private  Integer noticeType;

    private  String alarmDetail;

    private Date alarmTime;

    private  Integer siteId;

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

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
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
}
