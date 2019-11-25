package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.request.OperationRecordListReq;
import com.jialong.powersite.modular.system.model.response.OperationRecordListResp;
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
    public OperationRecordListResp queryAlarmLogList(@RequestBody OperationRecordListReq operationRecordListReq)
    {
        OperationRecordListResp operationRecordListResp = new OperationRecordListResp();
        return operationRecordService.queryOperationRecordList(operationRecordListReq, operationRecordListResp);
    }
}
