package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.request.SiteOperationReq;
import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.SiteOperationQueryRespData;
import com.jialong.powersite.modular.system.service.ISiteOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/siteoperation")
public class ApiSiteOperationController {

    @Autowired
    private ISiteOperationService siteOperationService;

    @RequestMapping("/list")
    public BaseBeanResp querySiteOperation(@RequestBody SiteOperationReq siteOperationReq)
    {
        BaseBeanResp<SiteOperationQueryRespData> baseBeanResp = new BaseBeanResp<>();
        return siteOperationService.querySiteOperationBySiteId(siteOperationReq, baseBeanResp);
    }

    @RequestMapping("/add")
    public BaseResp addSiteOperation(@RequestBody SiteOperationAddReq siteOperationAddReq)
    {
        BaseResp baseResp = new BaseResp();
        return siteOperationService.addSiteOperation(siteOperationAddReq, baseResp);
    }
}
