package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.request.SiteOperationReq;
import com.jialong.powersite.modular.system.model.response.SiteOperationAddResp;
import com.jialong.powersite.modular.system.model.response.SiteOperationResp;
import com.jialong.powersite.modular.system.service.IPowerSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/powersite")
public class PowerSiteController {

    @Autowired
    private IPowerSiteService powerSiteService;

    @RequestMapping("/list")
    public SiteOperationResp querySiteOperation(@RequestBody SiteOperationReq siteOperationReq)
    {
        SiteOperationResp siteOperationResp = new SiteOperationResp();
        return powerSiteService.queryPowerSiteBySiteId(siteOperationReq, siteOperationResp);
    }

    @RequestMapping("/add")
    public SiteOperationAddResp addPowerSiteDetail(@RequestBody SiteOperationAddReq siteOperationAddReq)
    {
        SiteOperationAddResp siteOperationAddResp  = new  SiteOperationAddResp();
        return powerSiteService.addPowerSiteData(siteOperationAddReq, siteOperationAddResp);
    }

}
