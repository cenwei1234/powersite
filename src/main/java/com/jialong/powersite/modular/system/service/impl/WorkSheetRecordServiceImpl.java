package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.WorkSheetRecordMapper;
import com.jialong.powersite.modular.system.model.JlWorkSheetRecord;
import com.jialong.powersite.modular.system.model.request.WorkSheetAddReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetListReq;
import com.jialong.powersite.modular.system.model.response.WorkSheetAddRsp;
import com.jialong.powersite.modular.system.model.response.WorkSheetListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkSheetRecordServiceImpl implements com.jialong.powersite.modular.system.service.IWorkSheetRecordService {

    @Autowired
    private WorkSheetRecordMapper workSheetRecordMapper;

    @Override
    public WorkSheetAddRsp addWorkSheet(WorkSheetAddReq workSheetAddReq, WorkSheetAddRsp workSheetAddRsp)
    {
        workSheetRecordMapper.insertWorkSheet(workSheetAddReq.getJlWorkSheetRecord());
        return workSheetAddRsp;
    }

    @Override
    public WorkSheetListResp queryWorkSheet(WorkSheetListReq workSheetListReq, WorkSheetListResp workSheetListResp)
    {
        List<JlWorkSheetRecord> jlWorkSheetRecords = workSheetRecordMapper.queryWorkSheet();
        workSheetListResp.setData(jlWorkSheetRecords);
        return workSheetListResp;
    }
}
