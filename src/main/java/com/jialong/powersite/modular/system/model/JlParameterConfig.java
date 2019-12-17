package com.jialong.powersite.modular.system.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JlParameterConfig {

    @JsonProperty(value = "param_type")
    private  Integer id;

    //参数名称
    private  String paramName = "";

    //参数值类型(0 数值 1 状态值 top=0的时候才有值)
    private  Integer paramValueType;

    private  Integer isTop;

    private  Integer pid;

    private Integer level;

    private Integer num;

    //参数值类型
    private  String paramValueUnit;

    //参数图标icon
    private  String paramIcon;

    //上临界值
    private  String paramUpperValue;

    //下临界值
    private  String paramLowerValue;

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

    public Integer getParamValueType() {
        return paramValueType;
    }

    public void setParamValueType(Integer paramValueType) {
        this.paramValueType = paramValueType;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getParamValueUnit() {
        return paramValueUnit;
    }

    public void setParamValueUnit(String paramValueUnit) {
        this.paramValueUnit = paramValueUnit;
    }

    public String getParamIcon() {
        return paramIcon;
    }

    public void setParamIcon(String paramIcon) {
        this.paramIcon = paramIcon;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    @Override
    public String toString() {
        return "JlParameterConfig{" +
                "id=" + id +
                ", paramName='" + paramName + '\'' +
                ", paramValueType='" + paramValueType + '\'' +
                ", isTop=" + isTop +
                ", pid=" + pid +
                ", paramValueUnit='" + paramValueUnit + '\'' +
                ", paramIcon='" + paramIcon + '\'' +
                '}';
    }
}