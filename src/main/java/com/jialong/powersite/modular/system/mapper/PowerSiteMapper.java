package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlParameterConfig;
import com.jialong.powersite.modular.system.model.JlSiteOperation;
import com.jialong.powersite.modular.system.model.JlSiteOperationData;
import com.jialong.powersite.modular.system.model.RegionSite;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerSiteMapper {

    List<JlSiteOperationData> queryPowerSiteBySiteId(@Param("siteId") Integer siteId);

    Boolean addPowerSiteData(List<JlSiteOperation> jlSiteOperationList);

    List<JlParameterConfig> queryParamConfigBatch(@Param("ids") List<Integer> ids);

}
