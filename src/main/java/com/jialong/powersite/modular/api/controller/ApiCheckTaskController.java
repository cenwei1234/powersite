package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.request.CheckTaskAddReq;
import com.jialong.powersite.modular.system.model.request.CheckTaskListReq;
import com.jialong.powersite.modular.system.model.response.CheckTaskAddRsp;
import com.jialong.powersite.modular.system.model.response.CheckTaskListResp;
import com.jialong.powersite.modular.system.service.ICheckTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checktask")
public class ApiCheckTaskController {

    @Autowired
    private ICheckTaskService checkTaskService;

    @RequestMapping("/list")
    public CheckTaskListResp queryWorksheet(@RequestBody CheckTaskListReq checkTaskListReq)
    {
        CheckTaskListResp checkTaskListResp = new CheckTaskListResp();
        checkTaskService.queryCheckTask(checkTaskListReq, checkTaskListResp);
        return checkTaskListResp;
    }

    @RequestMapping("/add")
    public CheckTaskAddRsp addCheckTask(@RequestBody CheckTaskAddReq checkTaskAddReq)
    {
        CheckTaskAddRsp checkTaskAddRsp = new CheckTaskAddRsp();
        checkTaskService.addCheckTask(checkTaskAddReq,checkTaskAddRsp);
        return checkTaskAddRsp;
    }
}
