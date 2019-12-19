package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.JlCity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {

    List<JlCity> queryCityListByPid(@Param("pid") Integer pic);
}