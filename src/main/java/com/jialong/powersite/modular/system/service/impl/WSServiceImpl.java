package com.jialong.powersite.modular.system.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jialong.powersite.core.utils.TopicServer;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.request.OperationRecordListReq;
import com.jialong.powersite.modular.system.model.response.AlarmLogListResp;
import com.jialong.powersite.modular.system.model.response.OperationRecordListResp;
import com.jialong.powersite.modular.system.service.IAlarmLogService;
import com.jialong.powersite.modular.system.service.IOperationRecordService;
import com.jialong.powersite.modular.system.service.IWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@EnableScheduling
public class WSServiceImpl implements IWSService {

    @Autowired
    private IAlarmLogService alarmLogService;

    @Autowired
    private IOperationRecordService operationRecordService;

    public static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @Scheduled(fixedRate = 5000)
    public void pushAlarmLog() throws IOException {

        AlarmLogListReq alarmLogListReq = new AlarmLogListReq();
        AlarmLogListResp alarmLogListResp = new AlarmLogListResp();
        alarmLogService.queryAlarmLogList(alarmLogListReq, alarmLogListResp);
        TopicServer.putMessage(objectMapper.writeValueAsString(alarmLogListResp));
    }

    @Override
    @Scheduled(fixedRate = 5000)
    public void pushOperationRecord() throws IOException{
        OperationRecordListReq operationRecordListReq = new OperationRecordListReq();
        OperationRecordListResp operationRecordListResp = new OperationRecordListResp();
        operationRecordService.queryOperationRecordList(operationRecordListReq, operationRecordListResp);
        TopicServer.putMessage(objectMapper.writeValueAsString(operationRecordListResp));
    }
}
