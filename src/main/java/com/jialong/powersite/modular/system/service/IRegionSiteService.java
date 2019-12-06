package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.RegionSite;
import com.jialong.powersite.modular.system.model.request.RegionSiteListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;

public interface IRegionSiteService {

    BaseListResp queryRegionSiteList(RegionSiteListReq regionSiteListReq, BaseListResp<RegionSite> baseListResp);

}
