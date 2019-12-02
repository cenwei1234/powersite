package com.jialong.powersite.modular.system.model;

public class JlSiteOperation {
	   
    private  Integer id;
     
	 //站房id
    private  Integer siteId;
     
	 //参数id(关联jl_parameter_config表id)
    private  Integer paramId;
     
	 //参数名称对应的值
    private  String paramValue;
     
	 //参数值类型[0代表状态值 1代表数值类型]
    private  Integer paramValueType;
     
	 //参数值单位
    private  String paramValueUnit;

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

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Integer getParamValueType() {
        return paramValueType;
    }

    public void setParamValueType(Integer paramValueType) {
        this.paramValueType = paramValueType;
    }

    public String getParamValueUnit() {
        return paramValueUnit;
    }

    public void setParamValueUnit(String paramValueUnit) {
        this.paramValueUnit = paramValueUnit;
    }
}