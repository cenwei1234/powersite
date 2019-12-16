package com.jialong.powersite.modular.system.model.response.data;

import com.jialong.powersite.modular.system.model.SiteOperationAddDeviceData;

import java.util.List;

public class SiteOperationQueryRespData {

    private Integer siteId;

    private String uuid;

    private List<SiteOperationAddDeviceData> deviceDataList;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public List<SiteOperationAddDeviceData> getDeviceDataList() {
        return deviceDataList;
    }

    public void setDeviceDataList(List<SiteOperationAddDeviceData> deviceDataList) {
        this.deviceDataList = deviceDataList;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
