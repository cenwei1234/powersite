package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.RegionSite;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionSiteMapper {

    List<RegionSite> queryRegionSiteList();

}
