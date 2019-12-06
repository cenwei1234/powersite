package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.AlarmLogGroupReq;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogGroupData;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogRespData;

public interface IAlarmLogService {

    BaseListResp queryAlarmLogList(AlarmLogListReq alarmLogListReq, BaseListResp<AlarmLogRespData> baseListResp);

    BaseListResp queryAlarmLogGroup(AlarmLogGroupReq alarmLogGroupReq, BaseListResp<AlarmLogGroupData> baseListResp);
}
