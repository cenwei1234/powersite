package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.RegionSite;
import com.jialong.powersite.modular.system.model.request.RegionSiteListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.service.IRegionSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/regionsite")
public class RegionSiteController {

    @Autowired
    private IRegionSiteService regionSiteService;


    @RequestMapping("/list")
    public BaseListResp queryRegionSite(@RequestBody RegionSiteListReq regionSiteListReq)
    {
        BaseListResp<RegionSite> baseListResp = new BaseListResp<>();
        return regionSiteService.queryRegionSiteList(regionSiteListReq, baseListResp);
    }
}
