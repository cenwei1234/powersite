package com.jialong.powersite.modular.system.model.response.data;

import com.jialong.powersite.modular.system.model.SiteOperationAddDeviceData;
import com.jialong.powersite.modular.system.model.SiteOperationListDeviceData;

import java.util.List;

public class SiteOperationQueryRespData {

    private Integer siteId;

    private String uuid;

    private List<SiteOperationListDeviceData> deviceDataList;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getUuid() {
        return uuid;
    }

    public List<SiteOperationListDeviceData> getDeviceDataList() {
        return deviceDataList;
    }

    public void setDeviceDataList(List<SiteOperationListDeviceData> deviceDataList) {
        this.deviceDataList = deviceDataList;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
