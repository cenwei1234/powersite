package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.JlSiteOperationData;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.request.SiteOperationReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
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

    @RequestMapping("/list")
    public BaseListResp querySiteOperation(@RequestBody SiteOperationReq siteOperationReq)
    {
        BaseListResp<JlSiteOperationData> baseListResp = new BaseListResp<>();
        return powerSiteService.queryPowerSiteBySiteId(siteOperationReq, baseListResp);
    }

    @RequestMapping("/add")
    public BaseResp addPowerSiteDetail(@RequestBody SiteOperationAddReq siteOperationAddReq)
    {
        BaseResp baseResp = new BaseResp();
        return powerSiteService.addPowerSiteData(siteOperationAddReq, baseResp);
    }

}
