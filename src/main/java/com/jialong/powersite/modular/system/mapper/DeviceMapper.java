package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlDevice;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceMapper {

    Integer addDevice(JlDevice jlDevice);

    JlDevice queryDeviceList(JlDevice jlDevice);
}
