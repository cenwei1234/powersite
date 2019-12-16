package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.OperationRecordAddData;
import com.jialong.powersite.modular.system.model.request.OperationRecordAddReq;
import com.jialong.powersite.modular.system.model.request.OperationRecordListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.OperationRecordRespData;
import com.jialong.powersite.modular.system.service.IOperationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operation")
public class ApiOperationRecordController {

    @Autowired
    private IOperationRecordService operationRecordService;

    @RequestMapping("/list")
    public BaseListResp queryAlarmLogList(@RequestBody OperationRecordListReq operationRecordListReq)
    {
        BaseListResp<OperationRecordRespData> baseListResp = new BaseListResp<>();
        return operationRecordService.queryOperationRecordList(operationRecordListReq, baseListResp);
    }

    @RequestMapping("/add")
    public BaseResp addOperationRecord(@RequestBody OperationRecordAddReq operationRecordAddReq)
    {
        BaseResp baseResp = new BaseResp();
        return operationRecordService.addOperationRecord(operationRecordAddReq, baseResp);
    }
}
