package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.request.AlarmLogAddReq;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogRespData;
import com.jialong.powersite.modular.system.service.IAlarmLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alarm")
public class ApiAlarmLogController {

    @Autowired
    private IAlarmLogService alarmLogService;

    @RequestMapping("/list")
    public BaseListResp queryAlarmLogList(@RequestBody AlarmLogListReq alarmLogListReq)
    {
        BaseListResp<AlarmLogRespData> baseListResp = new BaseListResp<>();
        return alarmLogService.queryAlarmLogList(alarmLogListReq, baseListResp);
    }

    @RequestMapping("/add")
    public BaseResp addAlarmLog(@RequestBody AlarmLogAddReq alarmLogAddReq)
    {
        BaseResp baseResp = new BaseResp();
        return alarmLogService.addAlarmLog(alarmLogAddReq, baseResp);
    }
}
