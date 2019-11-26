package com.jialong.powersite.modular.system.model;

public class JlSiteOperationData {
	   
    private  Integer id;
     
	 //站房id
    private  Integer siteId;

	 //参数名称对应的值
    private  String paramValue;

	 //参数值单位
    private  String paramValueUnit;

    //参数值单位
    private  String paramName;

    private  Integer pid;

    private  String pParamName;

    private  String pNodeNum;

    private  String pNodeLevel;

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

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamValueUnit() {
        return paramValueUnit;
    }

    public void setParamValueUnit(String paramValueUnit) {
        this.paramValueUnit = paramValueUnit;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getpParamName() {
        return pParamName;
    }

    public void setpParamName(String pParamName) {
        this.pParamName = pParamName;
    }

    public String getpNodeNum() {
        return pNodeNum;
    }

    public void setpNodeNum(String pNodeNum) {
        this.pNodeNum = pNodeNum;
    }

    public String getpNodeLevel() {
        return pNodeLevel;
    }

    public void setpNodeLevel(String pNodeLevel) {
        this.pNodeLevel = pNodeLevel;
    }

    @Override
    public String toString() {
        return "JlSiteOperationData{" +
                "id=" + id +
                ", siteId=" + siteId +
                ", paramValue='" + paramValue + '\'' +
                ", paramValueUnit='" + paramValueUnit + '\'' +
                ", paramName='" + paramName + '\'' +
                ", pid=" + pid +
                ", pParamName='" + pParamName + '\'' +
                ", pNodeNum='" + pNodeNum + '\'' +
                ", pNodeLevel='" + pNodeLevel + '\'' +
                '}';
    }
}