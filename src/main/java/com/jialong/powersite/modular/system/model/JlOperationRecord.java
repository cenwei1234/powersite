package com.jialong.powersite.modular.system.model;

import java.util.Date;

public class JlOperationRecord {

    private  long id;

    private  long auditor;

    private  long siteId;

    private  String operationDetail;

    private Date operationTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAuditor() {
        return auditor;
    }

    public void setAuditor(long auditor) {
        this.auditor = auditor;
    }

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public String getOperationDetail() {
        return operationDetail;
    }

    public void setOperationDetail(String operationDetail) {
        this.operationDetail = operationDetail;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    @Override
    public String toString() {
        return "JlOperationRecord{" +
                "id=" + id +
                ", auditor=" + auditor +
                ", siteId=" + siteId +
                ", operationDetail='" + operationDetail + '\'' +
                ", operationTime=" + operationTime +
                '}';
    }
}