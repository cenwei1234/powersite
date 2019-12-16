package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlSiteDeviceParam;
import com.jialong.powersite.modular.system.model.SiteDeviceParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteDeviceParamMapper {

    List<SiteDeviceParam> queryParamBySiteId(@Param("siteId") Integer siteId);
}
