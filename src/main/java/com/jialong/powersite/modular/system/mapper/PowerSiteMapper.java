package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerSiteMapper {

    Integer addPowerSite(PowerSite powerSite);
}
