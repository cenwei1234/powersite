package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.AlarmLogAddData;
import com.jialong.powersite.modular.system.model.JlAlarmLogQueryData;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogGroupData;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogRespData;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlarmLogMapper {

    int queryAlarmLogCount(JlAlarmLogQueryData jlAlarmLogQueryData);

    List<AlarmLogRespData> queryAlarmLogList(JlAlarmLogQueryData jlAlarmLogQueryData);

    List<AlarmLogGroupData> queryAlarmLogGroup();

    Integer addAlarmLog(AlarmLogAddData alarmLogAddData);
}