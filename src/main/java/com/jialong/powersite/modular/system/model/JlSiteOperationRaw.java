package com.jialong.powersite.modular.system.model;

public class JlSiteOperationRaw {

    private  Integer id;

    //站房id
    private  Integer siteId;

    private String uuid;

    //运行信息信息（json原始数据）
    private  String operationDetail;

    //记录添加时间
    private  String addTime;

    //以标识该站房的这条数据是否过期
    private  Integer isOverdue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Integer isOverdue) {
        this.isOverdue = isOverdue;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}