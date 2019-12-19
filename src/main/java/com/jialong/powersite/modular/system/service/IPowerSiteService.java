package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.modular.system.model.SiteDeviceListReq;
import com.jialong.powersite.modular.system.model.request.PowerSiteAddReq;
import com.jialong.powersite.modular.system.model.request.SiteDeviceAddReq;
import com.jialong.powersite.modular.system.model.request.SiteIpPortUpdateReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;


public interface IPowerSiteService {

    BaseResp addPowerSite(PowerSiteAddReq powerSiteAddReq, BaseResp baseResp);

    BaseResp updateSiteIpPort(SiteIpPortUpdateReq siteIpPortUpdateReq, BaseResp baseResp);

    BaseResp addSiteDevice(SiteDeviceAddReq siteDeviceAddReq, BaseResp baseResp);

    BaseListResp querySiteDevice(SiteDeviceListReq siteDeviceListReq, BaseListResp<ZTreeNode> baseListResp);
}
