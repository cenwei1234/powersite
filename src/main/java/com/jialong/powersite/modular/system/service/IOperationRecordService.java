package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.OperationRecordListReq;
import com.jialong.powersite.modular.system.model.response.OperationRecordListResp;

public interface IOperationRecordService {

    OperationRecordListResp queryOperationRecordList(OperationRecordListReq operationRecordListReq, OperationRecordListResp operationRecordListResp);

}
