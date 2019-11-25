package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.RegionSiteListReq;
import com.jialong.powersite.modular.system.model.response.RegionSiteListResp;
import com.jialong.powersite.modular.system.service.IRegionSiteService;
import com.jialong.powersite.modular.system.service.impl.RegionSiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/powersite")
public class RegionSiteController {

    @Autowired
    private IRegionSiteService regionSiteService;


    @RequestMapping("/list")
    public RegionSiteListResp queryRegionSite(@RequestBody RegionSiteListReq regionSiteListReq)
    {
        RegionSiteListResp regionSiteListResp = new RegionSiteListResp();
        return regionSiteService.queryRegionSiteList(regionSiteListReq, regionSiteListResp);
    }
}
