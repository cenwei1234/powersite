package com.jialong.powersite.modular.system.model.request;

import com.jialong.powersite.core.utils.Page;
import com.jialong.powersite.modular.system.model.JlOperationRecord;

import java.util.Date;

public class OperationRecordListReq extends Page<JlOperationRecord> {

    private  Integer auditor;

    private  Integer siteId;

    private  String operationDetail;

    private Date operationTime;

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

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

}
