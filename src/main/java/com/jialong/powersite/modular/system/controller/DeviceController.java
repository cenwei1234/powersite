package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.DeviceAddReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/device")
public class DeviceController {


    @Autowired
    private IDeviceService deviceService;

    @RequestMapping("/add")
    public BaseResp addDevice(@RequestBody DeviceAddReq deviceAddReq)
    {
        BaseResp baseResp = new BaseResp();
        deviceService.addDevice(deviceAddReq,baseResp);
        return baseResp;
    }
}
