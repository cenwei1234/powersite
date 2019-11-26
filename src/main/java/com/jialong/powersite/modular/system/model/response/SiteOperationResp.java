package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.JlSiteOperationData;

import java.util.List;

public class SiteOperationResp extends BaseResp{

    private List<JlSiteOperationData> data;

    public List<JlSiteOperationData> getData() {
        return data;
    }

    public void setData(List<JlSiteOperationData> data) {
        this.data = data;
    }
}
