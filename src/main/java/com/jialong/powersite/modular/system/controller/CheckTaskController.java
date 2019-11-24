package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.CheckTaskAddReq;
import com.jialong.powersite.modular.system.model.request.CheckTaskListReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetAddReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetListReq;
import com.jialong.powersite.modular.system.model.response.CheckTaskAddRsp;
import com.jialong.powersite.modular.system.model.response.CheckTaskListResp;
import com.jialong.powersite.modular.system.model.response.WorkSheetAddRsp;
import com.jialong.powersite.modular.system.model.response.WorkSheetListResp;
import com.jialong.powersite.modular.system.service.ICheckTaskService;
import com.jialong.powersite.modular.system.service.impl.CheckTaskServiceImpl;
import com.jialong.powersite.modular.system.service.impl.WorkSheetRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/checktask")
public class CheckTaskController {

    @Autowired
    private ICheckTaskService checkTaskService;

    @RequestMapping("/add")
    public CheckTaskAddRsp addWorksheet(@RequestBody CheckTaskAddReq checkTaskAddReq)
    {
        CheckTaskAddRsp checkTaskAddRsp = new CheckTaskAddRsp();
        checkTaskService.addCheckTask(checkTaskAddReq,checkTaskAddRsp);
        return checkTaskAddRsp;
    }

    @RequestMapping("/list")
    public CheckTaskListResp queryWorksheet(@RequestBody CheckTaskListReq checkTaskListReq)
    {
        CheckTaskListResp checkTaskListResp = new CheckTaskListResp();
        checkTaskService.queryCheckTask(checkTaskListReq, checkTaskListResp);
        return checkTaskListResp;
    }
}
