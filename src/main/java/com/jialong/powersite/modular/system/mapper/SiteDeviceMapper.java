package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlSiteDevice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteDeviceMapper {

    List<JlSiteDevice> querySiteDeviceBySiteId(@Param(("siteId")) Integer siteId, @Param("deviceIdList") List<Integer> deviceIdList);

    Integer addSiteDevice(JlSiteDevice jlSiteDevice);
}
