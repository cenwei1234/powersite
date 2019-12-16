package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.JlSiteOperationData;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.request.SiteOperationReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;

public interface ISiteOperationService {

    BaseListResp querySiteOperationBySiteId(SiteOperationReq siteOperationReq, BaseListResp<JlSiteOperationData> baseListResp);

    BaseResp addSiteOperation(SiteOperationAddReq siteOperationAddReq, BaseResp baseResp);

}
