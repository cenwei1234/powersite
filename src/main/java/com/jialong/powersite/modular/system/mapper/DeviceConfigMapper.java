package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlDeviceConfig;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceConfigMapper {

    Integer addDeviceConfig(JlDeviceConfig jlDeviceConfig);
}
