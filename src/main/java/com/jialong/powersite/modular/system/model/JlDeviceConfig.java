package com.jialong.powersite.modular.system.model;

public class JlDeviceConfig {
	   
    private  Integer id;
     
	//设备名称
    private  Integer deviceId;
     
	//配置项标识
    private  String configKey;
     
	//配置项值
    private  String configValue;
     
	//配置项值类型
    private  Integer configValueType;
     
	//配置项值显示json
    private  String configValueShow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public Integer getConfigValueType() {
        return configValueType;
    }

    public void setConfigValueType(Integer configValueType) {
        this.configValueType = configValueType;
    }

    public String getConfigValueShow() {
        return configValueShow;
    }

    public void setConfigValueShow(String configValueShow) {
        this.configValueShow = configValueShow;
    }
}