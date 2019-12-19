package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.modular.system.model.JlParameterConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterConfigMapper {

    List<JlParameterConfig> queryParamConfigBatch(@Param("ids") List<Integer> ids);

    Integer addParameterConfig(JlParameterConfig jlParameterConfig);

    List<ZTreeNode> queryDeviceParameterChecked(@Param("siteId") Integer siteId, @Param("deviceId") Integer deviceId);
}
