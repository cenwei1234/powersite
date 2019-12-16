package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.ParameterConfigMapper;
import com.jialong.powersite.modular.system.model.JlParameterConfig;
import com.jialong.powersite.modular.system.model.request.ParameterConfigAddReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.service.IParameterConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterConfigServiceImpl implements IParameterConfigService {

    @Autowired
    private ParameterConfigMapper parameterConfigMapper;

    @Override
    public BaseResp addParameterConfig(ParameterConfigAddReq parameterConfigAddReq, BaseResp baseResp) {
        JlParameterConfig jlParameterConfig = new JlParameterConfig();
        jlParameterConfig.setIsTop(parameterConfigAddReq.getIsTop());
        jlParameterConfig.setParamIcon(parameterConfigAddReq.getParamIcon());
        jlParameterConfig.setParamName(parameterConfigAddReq.getParamName());
        jlParameterConfig.setParamValueType(parameterConfigAddReq.getParamValueType());
        jlParameterConfig.setParamValueUnit(parameterConfigAddReq.getParamValueUnit());
        jlParameterConfig.setLevel(parameterConfigAddReq.getLevel());
        jlParameterConfig.setNum(parameterConfigAddReq.getNum());

        parameterConfigMapper.addParameterConfig(jlParameterConfig);
        return baseResp;
    }
}
