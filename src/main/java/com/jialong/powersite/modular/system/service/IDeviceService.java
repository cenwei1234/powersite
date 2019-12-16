package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.JlDevice;
import com.jialong.powersite.modular.system.model.request.DeviceAddReq;
import com.jialong.powersite.modular.system.model.request.DeviceListQueryReq;
import com.jialong.powersite.modular.system.model.request.DeviceParamAddReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;

public interface IDeviceService {

    BaseResp addDevice(DeviceAddReq deviceAddReq, BaseResp baseResp);

    BaseListResp<JlDevice> queryDevice(DeviceListQueryReq deviceListQueryReq, BaseListResp baseListResp);

    BaseResp addDeviceParam(DeviceParamAddReq deviceParamAddReq, BaseResp baseResp);
}
