package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.request.SiteOperationReq;
import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.SiteOperationQueryRespData;

public interface ISiteOperationService {

    BaseBeanResp querySiteOperationBySiteId(SiteOperationReq siteOperationReq, BaseBeanResp<SiteOperationQueryRespData> baseListResp);

    BaseResp addSiteOperation(SiteOperationAddReq siteOperationAddReq, BaseResp baseResp);

}
