package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.RegionSiteListReq;
import com.jialong.powersite.modular.system.model.response.RegionSiteListResp;

public interface IRegionSiteService {

    RegionSiteListResp queryRegionSiteList(RegionSiteListReq regionSiteListReq, RegionSiteListResp regionSiteListResp);

}
