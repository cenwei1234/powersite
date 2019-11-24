package com.jialong.powersite.modular.system.model;

import java.util.List;

public class RegionSite {

    private Integer id;
    private String latitude;
    private String longitude;
    private String siteAddr;
    private List<PowerSite> siteList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSiteAddr() {
        return siteAddr;
    }

    public void setSiteAddr(String siteAddr) {
        this.siteAddr = siteAddr;
    }

    public List<PowerSite> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<PowerSite> siteList) {
        this.siteList = siteList;
    }
}
