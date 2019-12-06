package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.WorkSheetRecordMapper;
import com.jialong.powersite.modular.system.model.JlWorkSheetRecord;
import com.jialong.powersite.modular.system.model.WorkSheetListQueryData;
import com.jialong.powersite.modular.system.model.request.WorkSheetAddReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.WorkSheetRecordRespData;
import com.jialong.powersite.modular.system.service.IWorkSheetRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkSheetRecordServiceImpl implements IWorkSheetRecordService {

    @Autowired
    private WorkSheetRecordMapper workSheetRecordMapper;

    @Override
    public BaseResp addWorkSheet(WorkSheetAddReq workSheetAddReq, BaseResp baseResp)
    {
        JlWorkSheetRecord jlWorkSheetRecord = new JlWorkSheetRecord();
        jlWorkSheetRecord.setOperatorId(workSheetAddReq.getOperatorId());
        jlWorkSheetRecord.setStatus(1);
        jlWorkSheetRecord.setSiteId(workSheetAddReq.getSiteId());
        jlWorkSheetRecord.setWorksheetDetail(workSheetAddReq.getWorksheetDetail());
        jlWorkSheetRecord.setAddTime(new Date());
        workSheetRecordMapper.insertWorkSheet(jlWorkSheetRecord);
        return baseResp;
    }

    @Override
    public BaseListResp queryWorkSheet(WorkSheetListReq workSheetListReq, BaseListResp<WorkSheetRecordRespData> baseListResp)
    {
        WorkSheetListQueryData workSheetListQueryData = new WorkSheetListQueryData();
        workSheetListQueryData.setSiteId(workSheetListReq.getSiteId());
        workSheetListQueryData.setStatus(workSheetListReq.getStatus());
        workSheetListQueryData.setOperatorId(workSheetListReq.getOperatorId());
        workSheetListQueryData.setWorksheetDetail(workSheetListReq.getWorksheetDetail());
        workSheetListQueryData.setStart(workSheetListReq.getStart(workSheetListReq.getPageNo()));
        workSheetListQueryData.setPageSize(workSheetListReq.getPageSize());
        workSheetListQueryData.setAddTimeBegin(workSheetListReq.getAddTimeBegin());
        workSheetListQueryData.setAddTimeEnd(workSheetListReq.getAddTimeEnd());
        Integer totalCount = workSheetRecordMapper.queryWorkSheetCount(workSheetListQueryData);
        List<WorkSheetRecordRespData> jlWorkSheetRecords = workSheetRecordMapper.queryWorkSheet(workSheetListQueryData);

        baseListResp.setTotalCount(totalCount);
        baseListResp.setData(jlWorkSheetRecords);
        return baseListResp;
    }
}
