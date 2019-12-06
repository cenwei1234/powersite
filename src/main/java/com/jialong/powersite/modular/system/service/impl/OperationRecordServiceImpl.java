package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.OperationRecordMapper;
import com.jialong.powersite.modular.system.model.JlOperationRecordQueryData;
import com.jialong.powersite.modular.system.model.request.OperationRecordListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.data.OperationRecordRespData;
import com.jialong.powersite.modular.system.service.IOperationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationRecordServiceImpl implements IOperationRecordService {

    @Autowired
    private OperationRecordMapper operationRecordMapper;

    @Override
    public BaseListResp queryOperationRecordList(OperationRecordListReq operationRecordListReq, BaseListResp<OperationRecordRespData> baseListResp)
    {
        JlOperationRecordQueryData jlOperationRecordQueryData = new JlOperationRecordQueryData();
        jlOperationRecordQueryData.setAuditor(operationRecordListReq.getAuditor());
        jlOperationRecordQueryData.setSiteId(operationRecordListReq.getSiteId());
        jlOperationRecordQueryData.setOperationDetail(operationRecordListReq.getOperationDetail());
        jlOperationRecordQueryData.setOperationTimeBegin(operationRecordListReq.getOperationTimeBegin());
        jlOperationRecordQueryData.setOperationTimeEnd(operationRecordListReq.getOperationTimeEnd());
        jlOperationRecordQueryData.setStart(operationRecordListReq.getStart(operationRecordListReq.getPageNo()));
        jlOperationRecordQueryData.setPageSize(operationRecordListReq.getPageSize());

        Integer totalCount = operationRecordMapper.queryOperationRecordCount(jlOperationRecordQueryData);
        baseListResp.setTotalCount(totalCount);

        List<OperationRecordRespData> jlOperationRecords = operationRecordMapper.queryOperationRecordList(jlOperationRecordQueryData);

        baseListResp.setData(jlOperationRecords);
        return baseListResp;
    }
}
