package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.core.utils.Pagination;
import com.jialong.powersite.modular.system.mapper.OperationRecordMapper;
import com.jialong.powersite.modular.system.model.JlOperationRecord;
import com.jialong.powersite.modular.system.model.request.OperationRecordListReq;
import com.jialong.powersite.modular.system.model.response.OperationRecordListResp;
import com.jialong.powersite.modular.system.service.IOperationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationRecordServiceImpl implements IOperationRecordService {

    @Autowired
    private OperationRecordMapper operationRecordMapper;

    @Override
    public OperationRecordListResp queryOperationRecordList(OperationRecordListReq operationRecordListReq, OperationRecordListResp operationRecordListResp)
    {
        Pagination pagination = new Pagination();
        pagination.setStart(operationRecordListReq.getStart(operationRecordListReq.getPageNo()));
        pagination.setPageSize(operationRecordListReq.getPageSize());
        List<JlOperationRecord> jlOperationRecords = operationRecordMapper.queryOperationRecordList(pagination);
        Integer totalCount = operationRecordMapper.queryOperationRecordCount();
        operationRecordListResp.setTotalCount(totalCount);
        operationRecordListResp.setData(jlOperationRecords);
        return operationRecordListResp;
    }
}
