package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.request.WorkSheetAddReq;
import com.jialong.powersite.modular.system.model.request.WorkSheetListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.WorkSheetRecordRespData;
import com.jialong.powersite.modular.system.service.IWorkSheetRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/worksheet")
public class ApiWorkSheetController {

    @Autowired
    private IWorkSheetRecordService workSheetRecordService;

    @RequestMapping("/list")
    public BaseListResp queryWorksheet(@RequestBody WorkSheetListReq workSheetListReq)
    {
        BaseListResp<WorkSheetRecordRespData> baseListResp = new BaseListResp<>();
        workSheetRecordService.queryWorkSheet(workSheetListReq,baseListResp);
        return baseListResp;
    }

    @RequestMapping("/add")
    public BaseResp addWorksheet(@RequestBody WorkSheetAddReq workSheetAddReq)
    {
        BaseResp baseResp = new BaseResp();
        workSheetRecordService.addWorkSheet(workSheetAddReq,baseResp);
        return baseResp;
    }
}
