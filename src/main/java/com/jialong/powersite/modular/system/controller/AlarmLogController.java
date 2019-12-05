package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.AlarmLogGroupReq;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.response.AlarmLogGroupResp;
import com.jialong.powersite.modular.system.model.response.AlarmLogListResp;
import com.jialong.powersite.modular.system.service.IAlarmLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin/alarm")
@RestController
public class AlarmLogController {

    @Autowired
    private IAlarmLogService alarmLogService;

    @RequestMapping("/list")
    public AlarmLogListResp queryAlarmLogList(@RequestBody AlarmLogListReq alarmLogListReq)
    {
        AlarmLogListResp alarmLogListResp = new AlarmLogListResp();
        return alarmLogService.queryAlarmLogList(alarmLogListReq, alarmLogListResp);
    }


    @RequestMapping("/group")
    public AlarmLogGroupResp queryAlarmLogList(@RequestBody AlarmLogGroupReq alarmLogGroupReq)
    {
        AlarmLogGroupResp alarmLogGroupResp = new AlarmLogGroupResp();
        return alarmLogService.queryAlarmLogGroup(alarmLogGroupReq, alarmLogGroupResp);
    }
}
