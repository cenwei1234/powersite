package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.ParameterConfigAddReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;


public interface IParameterConfigService {

    BaseResp addParameterConfig(ParameterConfigAddReq parameterConfigAddReq, BaseResp baseResp);
}
