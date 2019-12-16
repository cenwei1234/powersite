package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.SiteDeviceParam;
import com.jialong.powersite.modular.system.model.request.SiteParamQueryReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.service.ISiteParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sitedeviceparam")
public class ApiSiteParamController {

    @Autowired
    private ISiteParamService siteParamService;

    @RequestMapping("/list")
    public BaseListResp querySiteParam(@RequestBody SiteParamQueryReq siteParamQueryReq)
    {
        BaseListResp<SiteDeviceParam> baseListResp = new BaseListResp<>();
        return siteParamService.queryParamBySiteId(siteParamQueryReq, baseListResp);
    }
}
