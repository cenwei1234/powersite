package com.jialong.powersite.modular.system.model.response.data;

import java.util.Date;

public class WorkSheetRecordRespData {

    private  Integer id;

    private  String siteName;

    private  Integer status;

    private  String username;

    private  String worksheetDetail;

    private Date addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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