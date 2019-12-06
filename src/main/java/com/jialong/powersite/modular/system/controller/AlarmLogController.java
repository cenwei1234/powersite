package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.AlarmLogGroupReq;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogGroupData;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogRespData;
import com.jialong.powersite.modular.system.service.IAlarmLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin/alarm")
@RestController
public class AlarmLogController {

    @Autowired
    private IAlarmLogService alarmLogService;

    @RequestMapping("/list")
    public BaseListResp queryAlarmLogList(@RequestBody AlarmLogListReq alarmLogListReq)
    {
        BaseListResp<AlarmLogRespData> baseListResp = new BaseListResp<>();
        return alarmLogService.queryAlarmLogList(alarmLogListReq, baseListResp);
    }


    @RequestMapping("/group")
    public BaseListResp queryAlarmLogList(@RequestBody AlarmLogGroupReq alarmLogGroupReq)
    {
        BaseListResp<AlarmLogGroupData> baseListResp = new BaseListResp<>();
        return alarmLogService.queryAlarmLogGroup(alarmLogGroupReq, baseListResp);
    }
}
