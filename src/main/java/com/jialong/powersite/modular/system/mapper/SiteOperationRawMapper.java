package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlSiteOperationRaw;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteOperationRawMapper {

    Boolean addSiteOperationRaw(JlSiteOperationRaw jlSiteOperationRaw);

    Boolean updateSiteOperationRawBySiteId(JlSiteOperationRaw jlSiteOperationRaw);
}
