package com.jialong.powersite.modular.system.model;

public class JlDeviceOperation {
	   
    private  Integer id;
     
	//设备名称
    private  Integer deviceId;
     
	//操作项标识
    private  String operationKey;
     
	//操作项值
    private  String operationValue;
     
	//操作项值类型
    private  Integer operationValueType;
     
	//操作项值显示json
    private  String operationValueShow;

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

    public String getOperationKey() {
        return operationKey;
    }

    public void setOperationKey(String operationKey) {
        this.operationKey = operationKey;
    }

    public String getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(String operationValue) {
        this.operationValue = operationValue;
    }

    public Integer getOperationValueType() {
        return operationValueType;
    }

    public void setOperationValueType(Integer operationValueType) {
        this.operationValueType = operationValueType;
    }

    public String getOperationValueShow() {
        return operationValueShow;
    }

    public void setOperationValueShow(String operationValueShow) {
        this.operationValueShow = operationValueShow;
    }
}