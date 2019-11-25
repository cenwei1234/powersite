package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.response.AlarmLogListResp;
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
    public AlarmLogListResp queryAlarmLogList(@RequestBody AlarmLogListReq alarmLogListReq)
    {
        AlarmLogListResp alarmLogListResp = new AlarmLogListResp();
        return alarmLogService.queryAlarmLogList(alarmLogListReq, alarmLogListResp);
    }
}
