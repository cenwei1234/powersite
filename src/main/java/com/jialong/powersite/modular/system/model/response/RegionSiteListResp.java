package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.RegionSite;

import java.util.List;

public class RegionSiteListResp extends BaseResp {

    private List<RegionSite> data;

    public List<RegionSite> getData() {
        return data;
    }

    public void setData(List<RegionSite> data) {
        this.data = data;
    }
}
