package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.AlarmLogMapper;
import com.jialong.powersite.modular.system.model.JlAlarmLogQueryData;
import com.jialong.powersite.modular.system.model.request.AlarmLogGroupReq;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.response.AlarmLogGroupResp;
import com.jialong.powersite.modular.system.model.response.AlarmLogListResp;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogGroupData;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogRespData;
import com.jialong.powersite.modular.system.service.IAlarmLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmLogServiceImpl implements IAlarmLogService {

    @Autowired
    private AlarmLogMapper alarmLogMapper;

    @Override
    public AlarmLogListResp queryAlarmLogList(AlarmLogListReq alarmLogListReq, AlarmLogListResp alarmLogListResp)
    {
        JlAlarmLogQueryData jlAlarmLogQueryData = new JlAlarmLogQueryData();
        jlAlarmLogQueryData.setStart(alarmLogListReq.getStart(alarmLogListReq.getPageNo()));
        jlAlarmLogQueryData.setPageSize(alarmLogListReq.getPageSize());
        jlAlarmLogQueryData.setNoticeType(alarmLogListReq.getNoticeType());
        jlAlarmLogQueryData.setAlarmDetail(alarmLogListReq.getAlarmDetail());
        jlAlarmLogQueryData.setAuditor(alarmLogListReq.getAuditor());
        jlAlarmLogQueryData.setSiteId(alarmLogListReq.getSiteId());
        jlAlarmLogQueryData.setAlarmLevel(alarmLogListReq.getAlarmLevel());
        jlAlarmLogQueryData.setAlarmDevice(alarmLogListReq.getAlarmDevice());
        jlAlarmLogQueryData.setSiteType(alarmLogListReq.getSiteType());
        jlAlarmLogQueryData.setTriggerValue(alarmLogListReq.getTriggerValue());
        jlAlarmLogQueryData.setAlarmTimeBegin(alarmLogListReq.getAlarmTimeBegin());
        jlAlarmLogQueryData.setAlarmTimeEnd(alarmLogListReq.getAlarmTimeEnd());


        List<AlarmLogRespData> jlAlarmLogs = alarmLogMapper.queryAlarmLogList(jlAlarmLogQueryData);
        int totalCount = alarmLogMapper.queryAlarmLogCount(jlAlarmLogQueryData);
        alarmLogListResp.setTotalCount(totalCount);
        alarmLogListResp.setData(jlAlarmLogs);
        return alarmLogListResp;
    }

    @Override
    public AlarmLogGroupResp queryAlarmLogGroup(AlarmLogGroupReq alarmLogGroupReq, AlarmLogGroupResp alarmLogGroupResp) {
        List<AlarmLogGroupData> alarmLogGroupData = this.alarmLogMapper.queryAlarmLogGroup();
        alarmLogGroupResp.setData(alarmLogGroupData);
        return alarmLogGroupResp;
    }
}
