package com.jialong.powersite.modular.system.model.request;

public class SiteOperationAddParamData {

    //参数id(关联jl_parameter_config表id)
    private  Integer paramId;

    //参数名称对应的值
    private  String paramValue;

    //参数名称
    private  String paramName;

    //参数值类型(0 数值 1 状态值 top=0的时候才有值)
    private  Integer paramValueType;

    //参数值类型
    private  String paramValueUnit;

    //上临界值
    private  String paramUpperValue;

    //下临界值
    private  String paramLowerValue;

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

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
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

    public String getParamUpperValue() {
        return paramUpperValue;
    }

    public void setParamUpperValue(String paramUpperValue) {
        this.paramUpperValue = paramUpperValue;
    }

    public String getParamLowerValue() {
        return paramLowerValue;
    }

    public void setParamLowerValue(String paramLowerValue) {
        this.paramLowerValue = paramLowerValue;
    }
}
