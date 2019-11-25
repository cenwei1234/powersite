package com.jialong.powersite.modular.system.model.request;

public class CheckTaskAddReq {

    private  long checker;

    private  String checkDetail;

    private  long siteId;

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
}
