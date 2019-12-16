package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.PowerSiteAddReq;
import com.jialong.powersite.modular.system.model.request.SiteIpPortUpdateReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;


public interface IPowerSiteService {

    BaseResp addPowerSite(PowerSiteAddReq powerSiteAddReq, BaseResp baseResp);

    BaseResp updateSiteIpPort(SiteIpPortUpdateReq siteIpPortUpdateReq, BaseResp baseResp);
}
