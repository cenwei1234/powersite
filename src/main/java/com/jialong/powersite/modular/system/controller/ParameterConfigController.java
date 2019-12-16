package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.CheckTaskAddReq;
import com.jialong.powersite.modular.system.model.request.ParameterConfigAddReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.service.IParameterConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/parameter")
public class ParameterConfigController {

    @Autowired
    private IParameterConfigService parameterConfigService;

    @RequestMapping("/add")
    public BaseResp addParameterConfig(@RequestBody ParameterConfigAddReq parameterConfigAddReq)
    {
        BaseResp baseResp = new BaseResp();
        parameterConfigService.addParameterConfig(parameterConfigAddReq, baseResp);
        return baseResp;
    }
}
