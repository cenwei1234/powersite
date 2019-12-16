package com.jialong.powersite.modular.system.model.request;

public class PowerSiteAddReq {

    private Integer rid;

    private String siteName;

    private String siteShortname;

    private String siteAddr;

    private Integer siteStatus;

    private String siteHost;

    private String sitePorts;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteShortname() {
        return siteShortname;
    }

    public void setSiteShortname(String siteShortname) {
        this.siteShortname = siteShortname;
    }

    public String getSiteAddr() {
        return siteAddr;
    }

    public void setSiteAddr(String siteAddr) {
        this.siteAddr = siteAddr;
    }

    public Integer getSiteStatus() {
        return siteStatus;
    }

    public void setSiteStatus(Integer siteStatus) {
        this.siteStatus = siteStatus;
    }

    public String getSiteHost() {
        return siteHost;
    }

    public void setSiteHost(String siteHost) {
        this.siteHost = siteHost;
    }

    public String getSitePorts() {
        return sitePorts;
    }

    public void setSitePorts(String sitePorts) {
        this.sitePorts = sitePorts;
    }
}
