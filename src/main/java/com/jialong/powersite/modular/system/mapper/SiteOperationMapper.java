package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlSiteOperation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteOperationMapper {

    Boolean addPowerSiteData(List<JlSiteOperation> jlSiteOperationList);

    Boolean updateSiteOperationState(JlSiteOperation jlSiteOperation);
}
