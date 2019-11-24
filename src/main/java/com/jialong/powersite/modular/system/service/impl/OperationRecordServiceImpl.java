package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.AlarmLogMapper;
import com.jialong.powersite.modular.system.mapper.OperationRecordMapper;
import com.jialong.powersite.modular.system.model.JlAlarmLog;
import com.jialong.powersite.modular.system.model.JlOperationRecord;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.request.OperationRecordListReq;
import com.jialong.powersite.modular.system.model.response.AlarmLogListResp;
import com.jialong.powersite.modular.system.model.response.OperationRecordListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationRecordServiceImpl implements com.jialong.powersite.modular.system.service.IOperationRecordService {

    @Autowired
    private OperationRecordMapper operationRecordMapper;

    @Override
    public OperationRecordListResp queryOperationRecordList(OperationRecordListReq operationRecordListReq, OperationRecordListResp operationRecordListResp)
    {
        List<JlOperationRecord> jlOperationRecords = operationRecordMapper.queryOperationRecordList();
        operationRecordListResp.setData(jlOperationRecords);
        return operationRecordListResp;
    }
}
