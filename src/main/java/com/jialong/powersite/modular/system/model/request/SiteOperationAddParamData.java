package com.jialong.powersite.modular.system.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SiteOperationAddParamData {

    //参数id(关联jl_parameter_config表id)
    @JsonProperty(value = "paramType")
    private  Integer paramId;

    //参数名称对应的值
    private  String paramValue;

    //参数名称
    private  String paramName;

    //参数值类型(0 数值 1 状态值 top=0的时候才有值)
    private  Integer paramValueType;

    //参数值类型
    private  String paramValueUnit;

    private  Boolean alert;

    private  Integer alertType;

    private  String alertTypeName;

    //上临界值
    private  String alertUpperValue;

    //下临界值
    private  String alertLowerValue;

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

    public String getAlertUpperValue() {
        return alertUpperValue;
    }

    public void setAlertUpperValue(String alertUpperValue) {
        this.alertUpperValue = alertUpperValue;
    }

    public String getAlertLowerValue() {
        return alertLowerValue;
    }

    public void setAlertLowerValue(String alertLowerValue) {
        this.alertLowerValue = alertLowerValue;
    }

    public Boolean getAlert() {
        return alert;
    }

    public void setAlert(Boolean alert) {
        this.alert = alert;
    }

    public Integer getAlertType() {
        return alertType;
    }

    public void setAlertType(Integer alertType) {
        this.alertType = alertType;
    }

    public String getAlertTypeName() {
        return alertTypeName;
    }

    public void setAlertTypeName(String alertTypeName) {
        this.alertTypeName = alertTypeName;
    }
}
