package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlSiteOperation;
import com.jialong.powersite.modular.system.model.JlSiteOperationData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteOperationMapper {

    List<JlSiteOperationData> queryPowerSiteOperationBySiteId(@Param("siteId") Integer siteId);

    Boolean addPowerSiteData(List<JlSiteOperation> jlSiteOperationList);

    Boolean updateSiteOperationState(JlSiteOperation jlSiteOperation);
}
