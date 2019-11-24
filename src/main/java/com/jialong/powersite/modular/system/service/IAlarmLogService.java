package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.response.AlarmLogListResp;

public interface IAlarmLogService {
    AlarmLogListResp queryAlarmLogList(AlarmLogListReq alarmLogListReq, AlarmLogListResp alarmLogListResp);
}
