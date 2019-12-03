package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlPowerSiteOperationDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerSiteOperationDetailMapper {

    Integer AddPowerSiteOperationDetail(JlPowerSiteOperationDetail jlPowerSiteOperationDetail);
}