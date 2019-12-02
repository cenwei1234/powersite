package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.JlPowerSiteOperationLog;

import java.util.List;

public class OperationLogGroupResp {

    private List<JlPowerSiteOperationLog> data;

    public List<JlPowerSiteOperationLog> getData() {
        return data;
    }

    public void setData(List<JlPowerSiteOperationLog> data) {
        this.data = data;
    }
}
