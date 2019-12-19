package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.modular.system.mapper.DeviceMapper;
import com.jialong.powersite.modular.system.mapper.DeviceParamMapper;
import com.jialong.powersite.modular.system.mapper.ParameterConfigMapper;
import com.jialong.powersite.modular.system.model.JlDevice;
import com.jialong.powersite.modular.system.model.JlDeviceParameterConfig;
import com.jialong.powersite.modular.system.model.request.DeviceAddReq;
import com.jialong.powersite.modular.system.model.request.DeviceListQueryReq;
import com.jialong.powersite.modular.system.model.request.DeviceParamAddReq;
import com.jialong.powersite.modular.system.model.request.DeviceParameterCheckedReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceParamMapper deviceParamMapper;

    @Autowired
    private ParameterConfigMapper parameterConfigMapper;

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

    @Override
    public BaseListResp<JlDevice> queryDevice(DeviceListQueryReq deviceListQueryReq, BaseListResp baseListResp) {
        JlDevice jlDevice = new JlDevice();
        return null;
    }

    @Override
    public BaseResp addDeviceParam(DeviceParamAddReq deviceParamAddReq, BaseResp baseResp)
    {
        JlDeviceParameterConfig jlDeviceParameterConfig = new JlDeviceParameterConfig();
        jlDeviceParameterConfig.setDeviceId(deviceParamAddReq.getDeviceId());
        jlDeviceParameterConfig.setParamId(deviceParamAddReq.getParamId());
        jlDeviceParameterConfig.setParamId(deviceParamAddReq.getParamId());
        jlDeviceParameterConfig.setAuditor(deviceParamAddReq.getAuditor());
        jlDeviceParameterConfig.setIsDel(0);
        this.deviceParamMapper.addDeviceParam(jlDeviceParameterConfig);
        return baseResp;
    }


    @Override
    public BaseListResp queryDeviceParameterChecked(DeviceParameterCheckedReq deviceParameterCheckedReq, BaseListResp<ZTreeNode> baseListResp)
    {
        List<ZTreeNode> zTreeNodeList = this.parameterConfigMapper.queryDeviceParameterChecked(deviceParameterCheckedReq.getSiteId(), deviceParameterCheckedReq.getDeviceId());
        baseListResp.setData(zTreeNodeList);
        return baseListResp;
    }
}
