package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlSiteIpport;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteIpPortMapper {

    Boolean updateSiteIpBySiteId(JlSiteIpport jlSiteIpport);

    Boolean addSiteIpPort(JlSiteIpport jlSiteIpport);
}