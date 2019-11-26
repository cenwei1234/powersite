package com.jialong.powersite.modular.system.model.request;

public class SiteOperationAddReq {

    //站房id
    private  Integer siteId;

    //参数id(关联jl_parameter_config表id)
    private  Integer[] paramId;

    //参数名称对应的值
    private  String[] paramValue;


    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer[] getParamId() {
        return paramId;
    }

    public void setParamId(Integer[] paramId) {
        this.paramId = paramId;
    }

    public String[] getParamValue() {
        return paramValue;
    }

    public void setParamValue(String[] paramValue) {
        this.paramValue = paramValue;
    }
}
