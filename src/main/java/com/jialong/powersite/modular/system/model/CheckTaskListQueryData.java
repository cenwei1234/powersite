package com.jialong.powersite.modular.system.model;

import com.jialong.powersite.core.utils.Pagination;

import java.util.Date;

public class CheckTaskListQueryData extends Pagination {

    private  Integer checker;

    private  String checkDetail;

    private  Integer siteId;

    private  Integer status;

    private Date addTime;

    public Integer getChecker() {
        return checker;
    }

    public void setChecker(Integer checker) {
        this.checker = checker;
    }

    public String getCheckDetail() {
        return checkDetail;
    }

    public void setCheckDetail(String checkDetail) {
        this.checkDetail = checkDetail;
    }

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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
