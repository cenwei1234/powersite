package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.PowerSiteMapper;
import com.jialong.powersite.modular.system.model.JlSiteOperation;
import com.jialong.powersite.modular.system.model.JlSiteOperationData;
import com.jialong.powersite.modular.system.model.request.SiteOperationAddReq;
import com.jialong.powersite.modular.system.model.request.SiteOperationReq;
import com.jialong.powersite.modular.system.model.response.SiteOperationAddResp;
import com.jialong.powersite.modular.system.model.response.SiteOperationResp;
import com.jialong.powersite.modular.system.service.IPowerSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        Integer paramCount = siteOperationAddReq.getParamId().length;

        for (Integer i = 0; i < paramCount; i++) {
            JlSiteOperation jlSiteOperation = new JlSiteOperation();
            jlSiteOperation.setSiteId(siteOperationAddReq.getSiteId());
            jlSiteOperation.setParamId(siteOperationAddReq.getParamId()[i]);
            jlSiteOperation.setParamValue(siteOperationAddReq.getParamValue()[i]);
            jlSiteOperationList.add(jlSiteOperation);
        }
        powerSiteMapper.addPowerSiteData(jlSiteOperationList);
        return siteOperationAddResp;
    }
}
