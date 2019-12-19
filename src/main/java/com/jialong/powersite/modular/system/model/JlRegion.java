package com.jialong.powersite.modular.system.model;

public class JlRegion {

    //区域主键
    private  Integer id;
     
	//纬度
    private  Integer latitude;
     
	//经度
    private  Integer longitude;
     
	//区地址
    private  String regionAddr;
     
	//对应城市名称(关联t_city的id)
    private  Integer cid;
     
	//区名称
    private  String regionName;
     
	//区编码
    private  String regionCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public String getRegionAddr() {
        return regionAddr;
    }

    public void setRegionAddr(String regionAddr) {
        this.regionAddr = regionAddr;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
}