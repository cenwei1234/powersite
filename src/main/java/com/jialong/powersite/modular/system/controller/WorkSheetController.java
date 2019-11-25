package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.WorkSheetAddReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetListReq;
import com.jialong.powersite.modular.system.model.response.WorkSheetAddRsp;
import com.jialong.powersite.modular.system.model.response.WorkSheetListResp;
import com.jialong.powersite.modular.system.service.IWorkSheetRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/worksheet")
public class WorkSheetController {

    @Autowired
    private IWorkSheetRecordService workSheetRecordService;

    @RequestMapping("/list")
    public WorkSheetListResp queryWorksheet(@RequestBody WorkSheetListReq workSheetListReq)
    {
        WorkSheetListResp workSheetListResp = new WorkSheetListResp();
        workSheetRecordService.queryWorkSheet(workSheetListReq,workSheetListResp);
        return workSheetListResp;
    }

    @RequestMapping("/add")
    public WorkSheetAddRsp addWorksheet(@RequestBody WorkSheetAddReq workSheetAddReq)
    {
        WorkSheetAddRsp workSheetAddRsp = new WorkSheetAddRsp();
        workSheetRecordService.addWorkSheet(workSheetAddReq,workSheetAddRsp);
        return workSheetAddRsp;
    }
}
