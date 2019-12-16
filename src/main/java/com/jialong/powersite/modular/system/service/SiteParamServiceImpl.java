package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.mapper.SiteDeviceParamMapper;
import com.jialong.powersite.modular.system.model.SiteDeviceParam;
import com.jialong.powersite.modular.system.model.request.SiteParamQueryReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteParamServiceImpl implements ISiteParamService{

    @Autowired
    private SiteDeviceParamMapper siteDeviceParamMapper;

    @Override
    public BaseListResp<SiteDeviceParam> queryParamBySiteId(SiteParamQueryReq siteParamQueryReq, BaseListResp<SiteDeviceParam> baseListResp) {
        Integer siteId = siteParamQueryReq.getSiteId();
        List<SiteDeviceParam> jlSiteParams = siteDeviceParamMapper.queryParamBySiteId(siteId);
        baseListResp.setData(jlSiteParams);
        return baseListResp;
    }
}
