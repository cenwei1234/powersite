package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.request.SiteOperationReq;
import com.jialong.powersite.modular.system.model.response.SiteOperationAddResp;
import com.jialong.powersite.modular.system.model.response.SiteOperationResp;


public interface IPowerSiteService {

    SiteOperationResp queryPowerSiteBySiteId(SiteOperationReq siteOperationReq, SiteOperationResp siteOperationResp);

    SiteOperationAddResp addPowerSiteData(SiteOperationAddReq siteOperationAddReq, SiteOperationAddResp siteOperationAddResp);
}
