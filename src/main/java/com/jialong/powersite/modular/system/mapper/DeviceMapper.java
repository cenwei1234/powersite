package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.modular.system.model.JlDevice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceMapper {

    Integer addDevice(JlDevice jlDevice);

    List<ZTreeNode> queryDeviceChecked(@Param("siteId") Integer siteId);
}
