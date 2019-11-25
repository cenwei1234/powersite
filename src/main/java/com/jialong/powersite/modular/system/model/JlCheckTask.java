package com.jialong.powersite.modular.system.model;

import java.util.Date;

public class JlCheckTask {

    private  long id;

    private  long checker;

    private  String checkDetail;

    private  long siteId;

    private  long status;

    private Date addTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChecker() {
        return checker;
    }

    public void setChecker(long checker) {
        this.checker = checker;
    }

    public String getCheckDetail() {
        return checkDetail;
    }

    public void setCheckDetail(String checkDetail) {
        this.checkDetail = checkDetail;
    }

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "JlCheckTask{" +
                "id=" + id +
                ", checker=" + checker +
                ", checkDetail='" + checkDetail + '\'' +
                ", siteId=" + siteId +
                ", status=" + status +
                ", addTime=" + addTime +
                '}';
    }
}