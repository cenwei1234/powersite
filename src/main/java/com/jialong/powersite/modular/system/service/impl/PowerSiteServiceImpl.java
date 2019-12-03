package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.core.exception.BizExceptionEnum;
import com.jialong.powersite.modular.system.mapper.PowerSiteMapper;
import com.jialong.powersite.modular.system.model.JlParameterConfig;
import com.jialong.powersite.modular.system.model.JlSiteOperation;
import com.jialong.powersite.modular.system.model.JlSiteOperationData;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.request.SiteOperationReq;
import com.jialong.powersite.modular.system.model.response.SiteOperationAddResp;
import com.jialong.powersite.modular.system.model.response.SiteOperationResp;
import com.jialong.powersite.modular.system.service.IPowerSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PowerSiteServiceImpl implements IPowerSiteService {

    @Autowired
    private PowerSiteMapper powerSiteMapper;

    @Override
    public SiteOperationResp queryPowerSiteBySiteId(SiteOperationReq siteOperationReq, SiteOperationResp siteOperationResp) {
        List<JlSiteOperationData> jlSiteOperationData = powerSiteMapper.queryPowerSiteBySiteId(siteOperationReq.getSiteId());
        siteOperationResp.setData(jlSiteOperationData);
        return siteOperationResp;
    }

    @Override
    public SiteOperationAddResp addPowerSiteData(SiteOperationAddReq siteOperationAddReq, SiteOperationAddResp siteOperationAddResp) {
        List<JlSiteOperation> jlSiteOperationList = new ArrayList<>();
        //校验
        Integer[] paramIdArr = siteOperationAddReq.getParamId();
        String[] paramValueArr = siteOperationAddReq.getParamValue();
        //校验参数值和参数数目是否一致
        if (paramIdArr.length != paramValueArr.length)
        {
            siteOperationAddResp.setErrorCode(String.valueOf(BizExceptionEnum.PARAM_CONFIG_ERROR.getCode()));
            siteOperationAddResp.setErrorMsg(BizExceptionEnum.PARAM_CONFIG_ERROR.getMessage());
            return siteOperationAddResp;
        }
        List<JlParameterConfig> jlParameterConfigs = powerSiteMapper.queryParamConfigBatch(Arrays.asList(paramIdArr));
        //这里证明提交的paramId数组有问题
        if (jlParameterConfigs.size() != paramIdArr.length)
        {
            siteOperationAddResp.setErrorCode(String.valueOf(BizExceptionEnum.PARAM_CONFIG_NOEXISTS.getCode()));
            siteOperationAddResp.setErrorMsg(BizExceptionEnum.PARAM_CONFIG_NOEXISTS.getMessage());
            return siteOperationAddResp;
        }

        Map<Integer,Integer> parameterConfigsMap =new HashMap<>();
        for (int index = 0; index < jlParameterConfigs.size(); index++) {
            //存储查询出集合中参数id和
            parameterConfigsMap.put(jlParameterConfigs.get(index).getId(),index);
        }

        for (int i = 0; i < paramIdArr.length; i++) {
            JlSiteOperation jlSiteOperation = new JlSiteOperation();
            jlSiteOperation.setSiteId(siteOperationAddReq.getSiteId());
            jlSiteOperation.setParamId(siteOperationAddReq.getParamId()[i]);
            jlSiteOperation.setParamValue(siteOperationAddReq.getParamValue()[i]);
            //获取对应的参数所在的List中的位置
            Integer paramIdIndex = parameterConfigsMap.get(siteOperationAddReq.getParamId()[i]);
            jlSiteOperation.setParamValueType(jlParameterConfigs.get(paramIdIndex).getParamValueType());
            jlSiteOperation.setParamValueUnit(jlParameterConfigs.get(paramIdIndex).getParamValueUnit());
            jlSiteOperationList.add(jlSiteOperation);
        }
        powerSiteMapper.addPowerSiteData(jlSiteOperationList);
        return siteOperationAddResp;
    }
}
