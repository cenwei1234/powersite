package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlSiteOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteOperationMapper {

    Boolean addPowerSiteData(List<JlSiteOperation> jlSiteOperationList);

    Boolean updateSiteOperationState(@Param("siteId") Integer siteId, @Param("isOverdue") Integer isOverdue, @Param("paramIdList") List<Integer> paramIdList);

    Integer deleteOverdueSiteOperation(@Param("beforeDate") String beforeDate);
}
