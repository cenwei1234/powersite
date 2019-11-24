package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.RegionSiteMapper;
import com.jialong.powersite.modular.system.model.RegionSite;
import com.jialong.powersite.modular.system.model.request.RegionSiteListReq;
import com.jialong.powersite.modular.system.model.response.RegionSiteListResp;
import com.jialong.powersite.modular.system.service.IRegionSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionSiteServiceImpl{

    @Autowired
    private RegionSiteMapper regionSiteMapper;

    public RegionSiteListResp queryRegionSiteList(RegionSiteListReq regionSiteListReq, RegionSiteListResp regionSiteListResp) {
        List<RegionSite> regionSites = this.regionSiteMapper.queryRegionSiteList();
        regionSiteListResp.setData(regionSites);
        return regionSiteListResp;
    }
}
