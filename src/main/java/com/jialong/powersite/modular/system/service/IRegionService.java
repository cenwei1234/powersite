package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.JlRegion;
import com.jialong.powersite.modular.system.model.request.RegionListQueryReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;

public interface IRegionService {

    BaseListResp<JlRegion> queryRegionListByCityId(RegionListQueryReq regionListQueryReq, BaseListResp<JlRegion> baseListResp);
}
