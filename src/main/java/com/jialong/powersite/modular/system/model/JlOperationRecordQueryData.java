package com.jialong.powersite.modular.system.model;

import com.jialong.powersite.core.utils.Pagination;

import java.util.Date;

public class JlOperationRecordQueryData extends Pagination {

    private  Integer auditor;

    private  Integer siteId;

    private  String operationDetail;

    private String operationTime;

    private String operationTimeBegin;

    private String operationTimeEnd;

    public Integer getAuditor() {
        return auditor;
    }

    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getOperationDetail() {
        return operationDetail;
    }

    public void setOperationDetail(String operationDetail) {
        this.operationDetail = operationDetail;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationTimeBegin() {
        return operationTimeBegin;
    }

    public void setOperationTimeBegin(String operationTimeBegin) {
        this.operationTimeBegin = operationTimeBegin;
    }

    public String getOperationTimeEnd() {
        return operationTimeEnd;
    }

    public void setOperationTimeEnd(String operationTimeEnd) {
        this.operationTimeEnd = operationTimeEnd;
    }

    @Override
    public String toString() {
        return "JlOperationRecord{" +
                ", auditor=" + auditor +
                ", siteId=" + siteId +
                ", operationDetail='" + operationDetail + '\'' +
                ", operationTime=" + operationTime +
                '}';
    }
}