package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.JlSiteOperationData;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.request.SiteOperationReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.service.ISiteOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/siteoperation")
public class ApiSiteOperationController {

    @Autowired
    private ISiteOperationService serviceOperationService;

    @RequestMapping("/list")
    public BaseListResp querySiteOperation(@RequestBody SiteOperationReq siteOperationReq)
    {
        BaseListResp<JlSiteOperationData> baseListResp = new BaseListResp<>();
        return serviceOperationService.querySiteOperationBySiteId(siteOperationReq, baseListResp);
    }

    @RequestMapping("/add")
    public BaseResp addSiteOperation(@RequestBody SiteOperationAddReq siteOperationAddReq)
    {
        BaseResp baseResp = new BaseResp();
        return serviceOperationService.addSiteOperation(siteOperationAddReq, baseResp);
    }
}
