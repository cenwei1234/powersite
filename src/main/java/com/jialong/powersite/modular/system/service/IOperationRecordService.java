package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.OperationRecordAddReq;
import com.jialong.powersite.modular.system.model.request.OperationRecordListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.OperationRecordRespData;

public interface IOperationRecordService {

    BaseListResp queryOperationRecordList(OperationRecordListReq operationRecordListReq, BaseListResp<OperationRecordRespData> baseListResp);

    BaseResp addOperationRecord(OperationRecordAddReq operationRecordAddReq, BaseResp baseResp);

}
