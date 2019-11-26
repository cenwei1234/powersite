package com.jialong.powersite.modular.system.model;

public class JlParameterConfig {

    private  Integer id;

    //参数名称
    private  String paramName = "";

    //参数值类型(0 数值 1 状态值 top=0的时候才有值)
    private  String paramValueType;

    private  Integer isTop;

    private  Integer pid;

    //参数值类型
    private  String paramValueUnit;

    //参数图标icon
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

    public String getParamValueType() {
        return paramValueType;
    }

    public void setParamValueType(String paramValueType) {
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