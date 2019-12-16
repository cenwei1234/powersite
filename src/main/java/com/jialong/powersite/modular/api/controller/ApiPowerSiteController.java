package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.request.SiteIpPortUpdateReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;
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

    @RequestMapping("/updateport")
    public BaseResp updateSiteIpPort(@RequestBody SiteIpPortUpdateReq siteIpPortUpdateReq)
    {
        BaseResp baseResp = new BaseResp();
        return powerSiteService.updateSiteIpPort(siteIpPortUpdateReq, baseResp);
    }

}
