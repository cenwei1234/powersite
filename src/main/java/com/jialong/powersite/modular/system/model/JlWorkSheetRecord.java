package com.jialong.powersite.modular.system.model;

import java.util.Date;

public class JlWorkSheetRecord {

    private  long id;

    private  long siteId;

    private  int status;

    private  long operatorId;

    private  String worksheetDetail;

    private Date addTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(long operatorId) {
        this.operatorId = operatorId;
    }

    public String getWorksheetDetail() {
        return worksheetDetail;
    }

    public void setWorksheetDetail(String worksheetDetail) {
        this.worksheetDetail = worksheetDetail;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}