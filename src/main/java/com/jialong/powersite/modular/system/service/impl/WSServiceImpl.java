package com.jialong.powersite.modular.system.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jialong.powersite.core.utils.TopicServer;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.request.OperationRecordListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.data.OperationRecordRespData;
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
    @Scheduled(fixedRate = 50000)
    public void pushAlarmLog() throws IOException {

        AlarmLogListReq alarmLogListReq = new AlarmLogListReq();
        //每次展示就展示第一页 每页20条数据
        alarmLogListReq.setPageNo(1);
        alarmLogListReq.setPageSize(20);
        BaseListResp alarmLogListResp = new BaseListResp();
        alarmLogService.queryAlarmLogList(alarmLogListReq, alarmLogListResp);
        TopicServer.putMessage(objectMapper.writeValueAsString(alarmLogListResp));
    }

    @Override
    @Scheduled(fixedRate = 50000)
    public void pushOperationRecord() throws IOException{
        OperationRecordListReq operationRecordListReq = new OperationRecordListReq();
        BaseListResp<OperationRecordRespData> baseListResp = new BaseListResp<>();
        operationRecordService.queryOperationRecordList(operationRecordListReq, baseListResp);
        TopicServer.putMessage(objectMapper.writeValueAsString(baseListResp));
    }
}
