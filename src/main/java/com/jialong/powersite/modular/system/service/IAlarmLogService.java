package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.AlarmLogGroupReq;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.response.AlarmLogGroupResp;
import com.jialong.powersite.modular.system.model.response.AlarmLogListResp;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogGroupData;

import java.util.List;

public interface IAlarmLogService {

    AlarmLogListResp queryAlarmLogList(AlarmLogListReq alarmLogListReq, AlarmLogListResp alarmLogListResp);

    AlarmLogGroupResp queryAlarmLogGroup(AlarmLogGroupReq alarmLogGroupReq, AlarmLogGroupResp alarmLogGroupResp);
}
