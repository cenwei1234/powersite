package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.PowerSiteAddReq;
import com.jialong.powersite.modular.system.model.request.SiteDeviceAddReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;
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

    @RequestMapping("/add")
    public BaseResp addPowerSite(@RequestBody PowerSiteAddReq powerSiteAddReq)
    {
        BaseResp baseResp = new BaseResp();
        return powerSiteService.addPowerSite(powerSiteAddReq, baseResp);
    }

    @RequestMapping("/addsitedevice")
    public BaseResp addSiteDevice(@RequestBody SiteDeviceAddReq siteDeviceAddReq)
    {
        BaseResp baseResp = new BaseResp();
        return powerSiteService.addSiteDevice(siteDeviceAddReq, baseResp);
    }

}
