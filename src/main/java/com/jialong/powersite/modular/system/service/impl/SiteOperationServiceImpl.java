package com.jialong.powersite.modular.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jialong.powersite.core.exception.BizExceptionEnum;
import com.jialong.powersite.modular.system.mapper.*;
import com.jialong.powersite.modular.system.model.*;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddParamData;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.request.SiteOperationReq;
import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.SiteOperationQueryRespData;
import com.jialong.powersite.modular.system.service.ISiteOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SiteOperationServiceImpl implements ISiteOperationService {

    @Autowired
    private SiteOperationMapper siteOperationMapper;

    @Autowired
    private ParameterConfigMapper parameterConfigMapper;

    @Autowired
    private SiteOperationRawMapper siteOperationRawMapper;

    @Autowired
    private SiteDeviceMapper siteDeviceMapper;

    @Autowired
    private DeviceParamMapper deviceParamMapper;

    @Override
    public BaseBeanResp querySiteOperationBySiteId(SiteOperationReq siteOperationReq, BaseBeanResp<SiteOperationQueryRespData> baseBeanResp) {
        JlSiteOperationRaw jlSiteOperationRaw = siteOperationRawMapper.querySiteOperationRawBySiteId(siteOperationReq.getSiteId());
        if (null != jlSiteOperationRaw)
        {
            String operationDetail = jlSiteOperationRaw.getOperationDetail();
            SiteOperationQueryRespData siteOperationQueryRespDataList = JSON.parseObject(operationDetail, new TypeReference<SiteOperationQueryRespData>() {});
            baseBeanResp.setData(siteOperationQueryRespDataList);
        }
        return baseBeanResp;
    }

    @Override
    public BaseResp addSiteOperation(SiteOperationAddReq siteOperationAddReq, BaseResp baseResp) {
        //对站点设备的校验
        verifyPowerDeviceData(siteOperationAddReq, baseResp);
        //对设备内参数的校验
        verifyDeviceParamData(siteOperationAddReq, baseResp);

        return processDeviceParamData(siteOperationAddReq, baseResp);
    }

    private BaseResp processDeviceParamData(SiteOperationAddReq siteOperationAddReq, BaseResp baseResp) {
        List<SiteOperationAddDeviceData> deviceDataList = siteOperationAddReq.getDeviceDataList();
        for (SiteOperationAddDeviceData siteOperationAddDeviceData : deviceDataList) {
            //处理每个设备里面的参数数据
            processParamData(siteOperationAddReq, baseResp, siteOperationAddDeviceData);
        }
        return baseResp;
    }

    private void processParamData(SiteOperationAddReq siteOperationAddReq, BaseResp baseResp, SiteOperationAddDeviceData siteOperationAddDeviceData) {
        List<JlSiteOperation> jlSiteOperationList = new ArrayList<>();
        List<Integer> paramIdArr = new ArrayList<>();
        List<String> paramValueArr = new ArrayList<>();
        List<SiteOperationAddParamData> paramDataList = siteOperationAddDeviceData.getParamDataList();
        for (SiteOperationAddParamData siteOperationAddParamData : paramDataList) {
            paramIdArr.add(siteOperationAddParamData.getParamId());
            paramValueArr.add(siteOperationAddParamData.getParamValue());
        }
        List<JlParameterConfig> jlParameterConfigs = parameterConfigMapper.queryParamConfigBatch(paramIdArr);
        //以site_id和param_id联合条件作为标准 将已有的记录标识为过期 在查询的时候过滤过期的记录 同时新增的记录标识为未过期
        for (int i = 0; i < jlParameterConfigs.size(); i++) {
            JlSiteOperation jlSiteOperation = new JlSiteOperation();
            jlSiteOperation.setSiteId(siteOperationAddReq.getSiteId());
            jlSiteOperation.setParamId(jlParameterConfigs.get(i).getId());
            jlSiteOperation.setIsOverdue(0);
            siteOperationMapper.updateSiteOperationState(jlSiteOperation);
        }
        //这里构造一个Map 存储参数字典表中参数的id和在jlParameterConfigs中的索引
        Map<Integer, Integer> parameterConfigsMap = new HashMap<>();
        for (int index = 0; index < jlParameterConfigs.size(); index++) {
            //存储查询出集合中参数id和
            parameterConfigsMap.put(jlParameterConfigs.get(index).getId(), index);
        }

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式

        for (int i = 0; i < paramIdArr.size(); i++) {
            JlSiteOperation jlSiteOperation = new JlSiteOperation();
            jlSiteOperation.setSiteId(siteOperationAddReq.getSiteId());
            jlSiteOperation.setUuid(siteOperationAddReq.getUuid());
            jlSiteOperation.setParamId(paramIdArr.get(i));
            jlSiteOperation.setParamValue(paramValueArr.get(i));
            //获取对应的参数所在的List中的位置 这里需要补充参数字典表里面的相关字段的值
            Integer paramIdIndex = parameterConfigsMap.get(paramIdArr.get(i));
            jlSiteOperation.setParamValueType(jlParameterConfigs.get(paramIdIndex).getParamValueType());
            jlSiteOperation.setParamValueUnit(jlParameterConfigs.get(paramIdIndex).getParamValueUnit());
            jlSiteOperation.setParamUpperValue(jlParameterConfigs.get(paramIdIndex).getParamUpperValue());
            jlSiteOperation.setParamLowerValue(jlParameterConfigs.get(paramIdIndex).getParamLowerValue());

            jlSiteOperation.setAddTime(dateFormat.format(now));
            jlSiteOperation.setIsOverdue(0);
            jlSiteOperationList.add(jlSiteOperation);
        }
        siteOperationMapper.addPowerSiteData(jlSiteOperationList);

        //间原始记录表里面同样的站点id的记录设置为过期
        JlSiteOperationRaw jlSiteOperationRaw = new JlSiteOperationRaw();
        jlSiteOperationRaw.setSiteId(siteOperationAddReq.getSiteId());
        jlSiteOperationRaw.setIsOverdue(1);
        siteOperationRawMapper.updateSiteOperationRawBySiteId(jlSiteOperationRaw);

        //在原始数据表里面存储
        jlSiteOperationRaw.setUuid(siteOperationAddReq.getUuid());
        jlSiteOperationRaw.setOperationDetail(siteOperationAddReq.getDeviceDataList().toString());
        jlSiteOperationRaw.setAddTime(dateFormat.format(now));
        jlSiteOperationRaw.setIsOverdue(0);
        ObjectMapper objectMapper = new ObjectMapper();
        String siteOperationAddReqStr = "";
        try {
            siteOperationAddReqStr = objectMapper.writeValueAsString(siteOperationAddReq);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        jlSiteOperationRaw.setOperationDetail(siteOperationAddReqStr);
        siteOperationRawMapper.addSiteOperationRaw(jlSiteOperationRaw);
    }

    private void verifyPowerDeviceData(SiteOperationAddReq siteOperationAddReq, BaseResp baseResp)
    {
        Integer siteId = siteOperationAddReq.getSiteId();
        List<SiteOperationAddDeviceData> deviceDataList = siteOperationAddReq.getDeviceDataList();
        List<Integer> deviceIdList = new ArrayList<>();
        for (SiteOperationAddDeviceData siteOperationAddDeviceData : deviceDataList) {
            deviceIdList.add(siteOperationAddDeviceData.getDeviceId());
        }
        List<JlSiteDevice> jlSiteDevices = siteDeviceMapper.querySiteDeviceBySiteId(siteId, deviceIdList);
        if (deviceIdList.size() != jlSiteDevices.size())
        {
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.PARAM_DEVICE_NOTMATCH.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.PARAM_DEVICE_NOTMATCH.getMessage());
        }
    }

    private void verifyDeviceParamData(SiteOperationAddReq siteOperationAddReq, BaseResp baseResp)
    {
        Integer siteId = siteOperationAddReq.getSiteId();
        List<SiteOperationAddDeviceData> deviceDataList = siteOperationAddReq.getDeviceDataList();
        List<Integer> deviceIdList = new ArrayList<>();
        int paramDataCount = 0;
        for (SiteOperationAddDeviceData siteOperationAddDeviceData : deviceDataList) {
            deviceIdList.add(siteOperationAddDeviceData.getDeviceId());
            List<SiteOperationAddParamData> paramDataList = siteOperationAddDeviceData.getParamDataList();
            paramDataCount += paramDataList.size();
        }
        List<JlDeviceParameterConfig> jlDeviceParameterConfigs = deviceParamMapper.queryDeviceParamBySiteIdAndDeviceId(siteId, deviceIdList);
        if (paramDataCount != jlDeviceParameterConfigs.size())
        {
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.PARAM_CONFIG_NOTMATCH.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.PARAM_CONFIG_NOTMATCH.getMessage());
        }
    }
}
