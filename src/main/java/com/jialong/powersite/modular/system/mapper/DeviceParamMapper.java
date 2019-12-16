package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlDeviceParameterConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceParamMapper {

    List<JlDeviceParameterConfig> queryDeviceParamBySiteIdAndDeviceId(@Param("siteId") Integer siteId, @Param("deviceIdList") List<Integer> deviceIdList);

    Integer addDeviceParam(JlDeviceParameterConfig jlDeviceParameterConfig);
}
