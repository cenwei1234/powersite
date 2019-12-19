package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.JlCity;
import com.jialong.powersite.modular.system.model.request.CityListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;

public interface ICityService {

    BaseListResp<JlCity> queryCityListByCityId(CityListReq cityListReq, BaseListResp<JlCity> baseListResp);
}
