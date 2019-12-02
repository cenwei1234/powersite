package com.jialong.powersite.modular.system.model;

public class JlPowerSiteOperationLog {

    private  Integer id;

    private  String paramName;

    private  String paramValue;

    private  String paramUnit;

    private  Integer paramValueType;

    private  String paramIcon;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamUnit() {
        return paramUnit;
    }

    public void setParamUnit(String paramUnit) {
        this.paramUnit = paramUnit;
    }

    public Integer getParamValueType() {
        return paramValueType;
    }

    public void setParamValueType(Integer paramValueType) {
        this.paramValueType = paramValueType;
    }

    public String getParamIcon() {
        return paramIcon;
    }

    public void setParamIcon(String paramIcon) {
        this.paramIcon = paramIcon;
    }

    @Override
    public String toString() {
        return "JlPowerSiteOperationLog{" +
                "id=" + id +
                ", paramName='" + paramName + '\'' +
                ", paramValue='" + paramValue + '\'' +
                ", paramUnit='" + paramUnit + '\'' +
                ", paramValueType=" + paramValueType +
                ", paramIcon='" + paramIcon + '\'' +
                '}';
    }
}