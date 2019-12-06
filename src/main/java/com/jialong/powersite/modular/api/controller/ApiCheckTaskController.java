package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.request.CheckTaskAddReq;
import com.jialong.powersite.modular.system.model.request.CheckTaskListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.CheckTaskRespData;
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
    public BaseListResp queryWorksheet(@RequestBody CheckTaskListReq checkTaskListReq)
    {
        BaseListResp<CheckTaskRespData> baseListResp = new BaseListResp();
        checkTaskService.queryCheckTask(checkTaskListReq, baseListResp);
        return baseListResp;
    }

    @RequestMapping("/add")
    public BaseResp addCheckTask(@RequestBody CheckTaskAddReq checkTaskAddReq)
    {
        BaseResp baseResp = new BaseResp();
        checkTaskService.addCheckTask(checkTaskAddReq,baseResp);
        return baseResp;
    }
}
