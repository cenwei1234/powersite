package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.PowerSiteMapper;
import com.jialong.powersite.modular.system.mapper.SiteDeviceMapper;
import com.jialong.powersite.modular.system.mapper.SiteIpPortMapper;
import com.jialong.powersite.modular.system.model.JlSiteDevice;
import com.jialong.powersite.modular.system.model.JlSiteIpport;
import com.jialong.powersite.modular.system.model.PowerSite;
import com.jialong.powersite.modular.system.model.request.PowerSiteAddReq;
import com.jialong.powersite.modular.system.model.request.SiteDeviceAddReq;
import com.jialong.powersite.modular.system.model.request.SiteIpPortUpdateReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.service.IPowerSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PowerSiteServiceImpl implements IPowerSiteService {

    @Autowired
    private PowerSiteMapper powerSiteMapper;

    @Autowired
    private SiteIpPortMapper siteIpPortMapper;

    @Autowired
    private SiteDeviceMapper siteDeviceMapper;

    @Override
    public BaseResp addPowerSite(PowerSiteAddReq powerSiteAddReq, BaseResp baseResp) {

        PowerSite powerSite = new PowerSite();
        powerSite.setRid(powerSiteAddReq.getRid());
        powerSite.setSiteAddr(powerSiteAddReq.getSiteAddr());
        powerSite.setSiteHost(powerSiteAddReq.getSiteHost());
        powerSite.setSiteName(powerSiteAddReq.getSiteName());
        powerSite.setSiteShortname(powerSiteAddReq.getSiteShortname());
        powerSite.setSitePorts(powerSiteAddReq.getSitePorts());
        powerSite.setSiteStatus(1);
        Integer siteId = powerSiteMapper.addPowerSite(powerSite);
        JlSiteIpport jlSiteIpport = new JlSiteIpport();
        jlSiteIpport.setSiteId(siteId);
        jlSiteIpport.setPublicIp(powerSiteAddReq.getPublicIp());
        jlSiteIpport.setStatusPort(powerSiteAddReq.getStatusPort());
        jlSiteIpport.setWebsocketPort(powerSiteAddReq.getWebsocketPort());
        jlSiteIpport.setUsername(powerSiteAddReq.getUsername());
        jlSiteIpport.setPassword(powerSiteAddReq.getPassword());
        jlSiteIpport.setHttpPort(powerSiteAddReq.getHttpPort());
        jlSiteIpport.setHttpsPort(powerSiteAddReq.getHttpsPort());
        jlSiteIpport.setTcpPort(powerSiteAddReq.getTcpPort());
        jlSiteIpport.setUdpPort(powerSiteAddReq.getUdpPort());
        jlSiteIpport.setRtspPort(powerSiteAddReq.getRtspPort());
        siteIpPortMapper.addSiteIpPort(jlSiteIpport);
        return baseResp;
    }

    @Override
    public BaseResp updateSiteIpPort(SiteIpPortUpdateReq siteIpPortUpdateReq, BaseResp baseResp) {
        JlSiteIpport jlSiteIpport = new JlSiteIpport();
        jlSiteIpport.setSiteId(siteIpPortUpdateReq.getSiteId());
        jlSiteIpport.setPublicIp(siteIpPortUpdateReq.getPublicIp());
        jlSiteIpport.setHttpPort(siteIpPortUpdateReq.getHttpPort());
        jlSiteIpport.setHttpsPort(siteIpPortUpdateReq.getHttpsPort());
        jlSiteIpport.setUsername(siteIpPortUpdateReq.getUsername());
        jlSiteIpport.setPassword(siteIpPortUpdateReq.getPassword());
        jlSiteIpport.setTcpPort(siteIpPortUpdateReq.getTcpPort());
        jlSiteIpport.setUdpPort(siteIpPortUpdateReq.getUdpPort());
        jlSiteIpport.setRtspPort(siteIpPortUpdateReq.getRtspPort());
        jlSiteIpport.setStatusPort(siteIpPortUpdateReq.getStatusPort());
        jlSiteIpport.setWebsocketPort(siteIpPortUpdateReq.getWebsocketPort());
        siteIpPortMapper.updateSiteIpBySiteId(jlSiteIpport);
        return baseResp;
    }

    @Override
    public BaseResp addSiteDevice(SiteDeviceAddReq siteDeviceAddReq, BaseResp baseResp){
        JlSiteDevice jlSiteDevice = new JlSiteDevice();
        jlSiteDevice.setDeviceId(siteDeviceAddReq.getDeviceId());
        jlSiteDevice.setSiteId(siteDeviceAddReq.getSiteId());
        jlSiteDevice.setAuditor(siteDeviceAddReq.getAuditor());
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        jlSiteDevice.setAddTime(dateFormat.format(now));
        jlSiteDevice.setIsDel(0);
        this.siteDeviceMapper.addSiteDevice(jlSiteDevice);
        return baseResp;
    }

}
