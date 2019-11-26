package com.jialong.powersite.modular.system.model;

import com.jialong.powersite.core.utils.Pagination;

public class JlAlarmLogQueryData extends Pagination {

    private  Integer noticeType;

    private  String alarmDetail;

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