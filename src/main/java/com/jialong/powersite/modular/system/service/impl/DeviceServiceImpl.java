package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.DeviceMapper;
import com.jialong.powersite.modular.system.model.JlDevice;
import com.jialong.powersite.modular.system.model.request.DeviceAddReq;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public BaseResp addDevice(DeviceAddReq deviceAddReq, BaseResp baseResp) {
        JlDevice jlDevice = new JlDevice();
        jlDevice.setDeviceName(deviceAddReq.getDeviceName());
        jlDevice.setAuditor(deviceAddReq.getAuditor());
        jlDevice.setIsDel(0);

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        jlDevice.setAddTime(dateFormat.format(now));

        deviceMapper.addDevice(jlDevice);
        return baseResp;
    }
}
