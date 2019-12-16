package com.jialong.powersite.modular.system.model.request;

import com.jialong.powersite.modular.system.model.SiteOperationAddDeviceData;

import java.util.List;

public class SiteOperationAddReq {

    //站房id
    private  Integer siteId;

    //参数id(关联jl_parameter_config表id)
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
}
