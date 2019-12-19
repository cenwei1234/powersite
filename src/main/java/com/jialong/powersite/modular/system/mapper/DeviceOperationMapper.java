package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlDeviceOperation;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceOperationMapper {

    Integer addDeviceOperation(JlDeviceOperation jlDeviceOperation);
}
