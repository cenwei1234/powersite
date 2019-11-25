package com.jialong.powersite.modular.system.model.request;

public class WorkSheetAddReq {

    private  long siteId;

    private  long operatorId;

    private  String worksheetDetail;

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
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
}
