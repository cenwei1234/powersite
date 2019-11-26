package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.response.SiteOperationAddResp;
import com.jialong.powersite.modular.system.service.IPowerSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/powersite")
public class ApiPowerSiteController {

    @Autowired
    private IPowerSiteService powerSiteService;

    @RequestMapping("/add")
    public SiteOperationAddResp addSiteOperation(@RequestBody SiteOperationAddReq siteOperationAddReq)
    {
        SiteOperationAddResp siteOperationAddResp = new SiteOperationAddResp();
        return powerSiteService.addPowerSiteData(siteOperationAddReq, siteOperationAddResp);
    }
}
