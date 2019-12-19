package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlSiteOperation;
import com.jialong.powersite.modular.system.model.JlSiteOperationRaw;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteOperationRawMapper {

    Boolean addSiteOperationRaw(JlSiteOperationRaw jlSiteOperationRaw);

    Boolean updateSiteOperationRawBySiteId(JlSiteOperationRaw jlSiteOperationRaw);

    JlSiteOperationRaw querySiteOperationRawBySiteId(@Param("siteId") Integer siteId);

    Integer deleteOverdueRawSiteOperation(@Param("beforeDate") String beforeDate);
}
