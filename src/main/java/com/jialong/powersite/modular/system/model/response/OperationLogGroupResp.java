package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.JlPowerSiteOperationDetail;

import java.util.List;

public class OperationLogGroupResp {

    private List<JlPowerSiteOperationDetail> data;

    public List<JlPowerSiteOperationDetail> getData() {
        return data;
    }

    public void setData(List<JlPowerSiteOperationDetail> data) {
        this.data = data;
    }
}
