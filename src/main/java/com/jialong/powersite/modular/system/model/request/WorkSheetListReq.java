package com.jialong.powersite.modular.system.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jialong.powersite.core.utils.Page;
import com.jialong.powersite.modular.system.model.JlWorkSheetRecord;

import java.util.Date;

public class WorkSheetListReq  extends Page<JlWorkSheetRecord> {

    private  Integer siteId;

    private  Integer status;

    private  Integer operatorId;

    private  String worksheetDetail;

    private String addTimeBegin;

    private String addTimeEnd;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getWorksheetDetail() {
        return worksheetDetail;
    }

    public void setWorksheetDetail(String worksheetDetail) {
        this.worksheetDetail = worksheetDetail;
    }

    public String getAddTimeBegin() {
        return addTimeBegin;
    }

    public void setAddTimeBegin(String addTimeBegin) {
        this.addTimeBegin = addTimeBegin;
    }

    public String getAddTimeEnd() {
        return addTimeEnd;
    }

    public void setAddTimeEnd(String addTimeEnd) {
        this.addTimeEnd = addTimeEnd;
    }
}
