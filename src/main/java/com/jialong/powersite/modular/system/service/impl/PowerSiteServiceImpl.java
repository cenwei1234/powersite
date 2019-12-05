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

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PowerSiteServiceImpl implements IPowerSiteService {

    @Autowired
    private PowerSiteMapper powerSiteMapper;

    @Override
    public SiteOperationResp queryPowerSiteBySiteId(SiteOperationReq siteOperationReq, SiteOperationResp siteOperationResp) {
        List<JlSiteOperationData> jlSiteOperationData = powerSiteMapper.queryPowerSiteOperationBySiteId(siteOperationReq.getSiteId());
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

        //以site_id和param_id联合条件作为标准 将已有的记录标识为过期 在查询的时候过滤过期的记录 同时新增的记录标识为未过期
        for (int i = 0; i < jlParameterConfigs.size(); i++) {
            JlSiteOperation jlSiteOperation = new JlSiteOperation();
            jlSiteOperation.setSiteId(siteOperationAddReq.getSiteId());
            jlSiteOperation.setParamId(jlParameterConfigs.get(i).getId());
            jlSiteOperation.setIsOverdue(0);
            powerSiteMapper.updateParamConfigState(jlSiteOperation);
        }


        Map<Integer,Integer> parameterConfigsMap =new HashMap<>();
        for (int index = 0; index < jlParameterConfigs.size(); index++) {
            //存储查询出集合中参数id和
            parameterConfigsMap.put(jlParameterConfigs.get(index).getId(),index);
        }

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式

        for (int i = 0; i < paramIdArr.length; i++) {
            JlSiteOperation jlSiteOperation = new JlSiteOperation();
            jlSiteOperation.setSiteId(siteOperationAddReq.getSiteId());
            jlSiteOperation.setParamId(siteOperationAddReq.getParamId()[i]);
            jlSiteOperation.setParamValue(siteOperationAddReq.getParamValue()[i]);
            //获取对应的参数所在的List中的位置
            Integer paramIdIndex = parameterConfigsMap.get(siteOperationAddReq.getParamId()[i]);
            jlSiteOperation.setParamValueType(jlParameterConfigs.get(paramIdIndex).getParamValueType());
            jlSiteOperation.setParamValueUnit(jlParameterConfigs.get(paramIdIndex).getParamValueUnit());
            jlSiteOperation.setAddTime(dateFormat.format(now));
            jlSiteOperation.setIsOverdue(0);
            jlSiteOperationList.add(jlSiteOperation);
        }
        powerSiteMapper.addPowerSiteData(jlSiteOperationList);
        return siteOperationAddResp;
    }
}
