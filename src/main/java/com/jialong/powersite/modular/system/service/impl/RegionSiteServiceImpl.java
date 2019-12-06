package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.RegionSiteMapper;
import com.jialong.powersite.modular.system.model.RegionSite;
import com.jialong.powersite.modular.system.model.request.RegionSiteListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.service.IRegionSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionSiteServiceImpl implements IRegionSiteService{

    @Autowired
    private RegionSiteMapper regionSiteMapper;

    public BaseListResp queryRegionSiteList(RegionSiteListReq regionSiteListReq, BaseListResp<RegionSite> baseListResp) {
        List<RegionSite> regionSites = this.regionSiteMapper.queryRegionSiteList();
        baseListResp.setData(regionSites);
        return baseListResp;
    }
}
