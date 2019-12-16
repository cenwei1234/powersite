package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.SiteDeviceParam;
import com.jialong.powersite.modular.system.model.request.SiteParamQueryReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;

public interface ISiteParamService {

    BaseListResp<SiteDeviceParam> queryParamBySiteId(SiteParamQueryReq siteParamQueryReq, BaseListResp<SiteDeviceParam> baseListResp);
}
