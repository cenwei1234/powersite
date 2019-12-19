package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.JlCity;
import com.jialong.powersite.modular.system.model.request.CityListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin/city")
public class CityController {

    @Autowired
    private ICityService cityService;


    @RequestMapping("/list")
    public BaseListResp queryCityList(@RequestBody CityListReq cityListReq)
    {
        BaseListResp<JlCity> baseListResp = new BaseListResp<>();
        return cityService.queryCityListByCityId(cityListReq, baseListResp);
    }
}
