package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.CheckTaskMapper;
import com.jialong.powersite.modular.system.mapper.WorkSheetRecordMapper;
import com.jialong.powersite.modular.system.model.JlCheckTask;
import com.jialong.powersite.modular.system.model.JlWorkSheetRecord;
import com.jialong.powersite.modular.system.model.request.CheckTaskAddReq;
import com.jialong.powersite.modular.system.model.request.CheckTaskListReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetAddReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetListReq;
import com.jialong.powersite.modular.system.model.response.CheckTaskAddRsp;
import com.jialong.powersite.modular.system.model.response.CheckTaskListResp;
import com.jialong.powersite.modular.system.model.response.WorkSheetAddRsp;
import com.jialong.powersite.modular.system.model.response.WorkSheetListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckTaskServiceImpl implements com.jialong.powersite.modular.system.service.ICheckTaskService {

    @Autowired
    private CheckTaskMapper checkTaskMapper;

    @Override
    public CheckTaskAddRsp addCheckTask(CheckTaskAddReq checkTaskAddReq, CheckTaskAddRsp checkTaskAddRsp)
    {
        checkTaskMapper.insertCheckTask(checkTaskAddReq.getJlCheckTask());
        return checkTaskAddRsp;
    }

    @Override
    public CheckTaskListResp queryCheckTask(CheckTaskListReq checkTaskListReq, CheckTaskListResp checkTaskListResp)
    {
        List<JlCheckTask> jlCheckTasks = checkTaskMapper.queryCheckTask();
        checkTaskListResp.setData(jlCheckTasks);
        return checkTaskListResp;
    }
}
