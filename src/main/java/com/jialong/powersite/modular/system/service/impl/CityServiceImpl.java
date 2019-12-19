package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.CityMapper;
import com.jialong.powersite.modular.system.model.JlCity;
import com.jialong.powersite.modular.system.model.request.CityListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public BaseListResp<JlCity> queryCityListByCityId(CityListReq cityListReq, BaseListResp<JlCity> baseListResp) {
        List<JlCity> jlCities = this.cityMapper.queryCityListByPid(cityListReq.getCid());
        baseListResp.setData(jlCities);
        return baseListResp;
    }
}
