package com.jialong.powersite.modular.system.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SiteDeviceParam {

    @JsonProperty(value = "device_type")
    private Integer id;

    private Integer deviceId;

    private List<JlSiteDeviceParam> paramList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }


    public List<JlSiteDeviceParam> getParamList() {
        return paramList;
    }

    public void setParamList(List<JlSiteDeviceParam> paramList) {
        this.paramList = paramList;
    }
}
