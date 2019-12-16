package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.CheckTaskMapper;
import com.jialong.powersite.modular.system.model.CheckTaskListQueryData;
import com.jialong.powersite.modular.system.model.JlCheckTask;
import com.jialong.powersite.modular.system.model.request.CheckTaskAddReq;
import com.jialong.powersite.modular.system.model.request.CheckTaskListReq;
import com.jialong.powersite.modular.system.model.request.CheckTaskStatusUpdateReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.CheckTaskRespData;
import com.jialong.powersite.modular.system.service.ICheckTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CheckTaskServiceImpl implements ICheckTaskService {

    @Autowired
    private CheckTaskMapper checkTaskMapper;

    @Override
    public BaseResp addCheckTask(CheckTaskAddReq checkTaskAddReq, BaseResp baseResp)
    {
        JlCheckTask jlCheckTask = new JlCheckTask();
        jlCheckTask.setChecker(checkTaskAddReq.getChecker());
        jlCheckTask.setSiteId(checkTaskAddReq.getSiteId());
        jlCheckTask.setCheckDetail(checkTaskAddReq.getCheckDetail());
        jlCheckTask.setAddTime(new Date());
        jlCheckTask.setStatus(1);
        checkTaskMapper.insertCheckTask(jlCheckTask);
        return baseResp;
    }

    @Override
    public BaseListResp queryCheckTask(CheckTaskListReq checkTaskListReq, BaseListResp<CheckTaskRespData> baseListResp)
    {
        CheckTaskListQueryData checkTaskListQueryData = new CheckTaskListQueryData();
        checkTaskListQueryData.setSiteId(checkTaskListReq.getSiteId());
        checkTaskListQueryData.setStatus(checkTaskListReq.getStatus());
        checkTaskListQueryData.setChecker(checkTaskListReq.getChecker());
        checkTaskListQueryData.setCheckDetail(checkTaskListReq.getCheckDetail());
        checkTaskListQueryData.setStart(checkTaskListReq.getStart(checkTaskListReq.getPageNo()));
        checkTaskListQueryData.setPageSize(checkTaskListReq.getPageSize());
        checkTaskListQueryData.setAddTimeBegin(checkTaskListReq.getAddTimeBegin());
        checkTaskListQueryData.setAddTimeEnd(checkTaskListReq.getAddTimeEnd());

        Integer totalCount = checkTaskMapper.queryCheckTaskCount(checkTaskListQueryData );
        List<CheckTaskRespData> jlCheckTasks = checkTaskMapper.queryCheckTask(checkTaskListQueryData );
        baseListResp.setTotalCount(totalCount);
        baseListResp.setData(jlCheckTasks);
        return baseListResp;
    }

    @Override
    public BaseResp updateCheckTaskStatus(CheckTaskStatusUpdateReq checkTaskStatusUpdateReq, BaseResp baseResp) {
        JlCheckTask jlCheckTask = new JlCheckTask();
        jlCheckTask.setId(checkTaskStatusUpdateReq.getId());
        jlCheckTask.setStatus(checkTaskStatusUpdateReq.getStatus());
        this.checkTaskMapper.updateCheckTaskStatus(jlCheckTask);
        return baseResp;
    }
}
