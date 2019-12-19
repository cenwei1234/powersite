package com.jialong.powersite.modular.system.model;

public class JlCity {
	   
	//区域主键
    private  Integer id;
     
	//城市名称
    private  String cityName;
     
	//城市编码
    private  String cityCode;
     
	//区域上级标识
    private  Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}