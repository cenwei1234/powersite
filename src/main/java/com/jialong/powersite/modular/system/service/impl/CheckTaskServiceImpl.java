package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.core.utils.Pagination;
import com.jialong.powersite.modular.system.mapper.CheckTaskMapper;
import com.jialong.powersite.modular.system.model.CheckTaskListQueryData;
import com.jialong.powersite.modular.system.model.JlCheckTask;
import com.jialong.powersite.modular.system.model.request.CheckTaskAddReq;
import com.jialong.powersite.modular.system.model.request.CheckTaskListReq;
import com.jialong.powersite.modular.system.model.response.CheckTaskAddRsp;
import com.jialong.powersite.modular.system.model.response.CheckTaskListResp;
import com.jialong.powersite.modular.system.model.response.data.CheckTaskRespData;
import com.jialong.powersite.modular.system.service.ICheckTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@Service
public class CheckTaskServiceImpl implements ICheckTaskService {

    @Autowired
    private CheckTaskMapper checkTaskMapper;

    @Override
    public CheckTaskAddRsp addCheckTask(CheckTaskAddReq checkTaskAddReq, CheckTaskAddRsp checkTaskAddRsp)
    {
        JlCheckTask jlCheckTask = new JlCheckTask();
        jlCheckTask.setChecker(checkTaskAddReq.getChecker());
        jlCheckTask.setSiteId(checkTaskAddReq.getSiteId());
        jlCheckTask.setCheckDetail(checkTaskAddReq.getCheckDetail());
        jlCheckTask.setAddTime(new Date());
        jlCheckTask.setStatus(1);
        checkTaskMapper.insertCheckTask(jlCheckTask);
        return checkTaskAddRsp;
    }

    @Override
    public CheckTaskListResp queryCheckTask(CheckTaskListReq checkTaskListReq, CheckTaskListResp checkTaskListResp)
    {
        CheckTaskListQueryData checkTaskListQueryData = new CheckTaskListQueryData();
        checkTaskListQueryData.setSiteId(checkTaskListReq.getSiteId());
        checkTaskListQueryData.setStatus(checkTaskListReq.getStatus());
        checkTaskListQueryData.setChecker(checkTaskListReq.getChecker());
        checkTaskListQueryData.setCheckDetail(checkTaskListReq.getCheckDetail());
        checkTaskListQueryData.setStart(checkTaskListReq.getStart(checkTaskListReq.getPageNo()));
        checkTaskListQueryData.setPageSize(checkTaskListReq.getPageSize());

        Integer totalCount = checkTaskMapper.queryCheckTaskCount(checkTaskListQueryData );
        List<CheckTaskRespData> jlCheckTasks = checkTaskMapper.queryCheckTask(checkTaskListQueryData );
        checkTaskListResp.setTotalCount(totalCount);
        checkTaskListResp.setData(jlCheckTasks);
        return checkTaskListResp;
    }
}
