package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.DeviceAddReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;

public interface IDeviceService {

    BaseResp addDevice(DeviceAddReq deviceAddReq, BaseResp baseResp);
}
