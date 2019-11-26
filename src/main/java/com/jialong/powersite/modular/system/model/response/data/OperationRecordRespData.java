package com.jialong.powersite.modular.system.model.response.data;

import java.util.Date;

public class OperationRecordRespData {

    private Integer id;

    private  String username;

    private  String siteName;

    private  String operationDetail;

    private Date operationTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
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
        return "OperationRecordRespData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", siteName='" + siteName + '\'' +
                ", operationDetail='" + operationDetail + '\'' +
                ", operationTime=" + operationTime +
                '}';
    }
}