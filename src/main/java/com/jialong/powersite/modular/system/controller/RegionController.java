package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.JlRegion;
import com.jialong.powersite.modular.system.model.request.RegionListQueryReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin/region")
public class RegionController {

    @Autowired
    private IRegionService regionService;


    @RequestMapping("/list")
    public BaseListResp queryRegionList(@RequestBody RegionListQueryReq regionListQueryReq)
    {
        BaseListResp<JlRegion> baseListResp = new BaseListResp<>();
        return regionService.queryRegionListByCityId(regionListQueryReq, baseListResp);
    }
}
