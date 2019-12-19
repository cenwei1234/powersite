package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.RegionMapper;
import com.jialong.powersite.modular.system.model.JlRegion;
import com.jialong.powersite.modular.system.model.request.RegionListQueryReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public BaseListResp<JlRegion> queryRegionListByCityId(RegionListQueryReq regionListQueryReq, BaseListResp<JlRegion> baseListResp) {
        List<JlRegion> jlRegions = this.regionMapper.queryRegionListByCityId(regionListQueryReq.getCid());
        baseListResp.setData(jlRegions);
        return baseListResp;
    }
}
