package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.modular.system.mapper.AlarmLogMapper;
import com.jialong.powersite.modular.system.model.JlAlarmLogQueryData;
import com.jialong.powersite.modular.system.model.request.AlarmLogGroupReq;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
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
    public BaseListResp queryAlarmLogList(AlarmLogListReq alarmLogListReq, BaseListResp<AlarmLogRespData> baseListResp)
    {
        JlAlarmLogQueryData jlAlarmLogQueryData = new JlAlarmLogQueryData();
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
        jlAlarmLogQueryData.setStart(alarmLogListReq.getStart(alarmLogListReq.getPageNo()));
        jlAlarmLogQueryData.setPageSize(alarmLogListReq.getPageSize());

        List<AlarmLogRespData> jlAlarmLogs = alarmLogMapper.queryAlarmLogList(jlAlarmLogQueryData);
        int totalCount = alarmLogMapper.queryAlarmLogCount(jlAlarmLogQueryData);
        baseListResp.setTotalCount(totalCount);
        baseListResp.setData(jlAlarmLogs);
        return baseListResp;
    }

    @Override
    public BaseListResp queryAlarmLogGroup(AlarmLogGroupReq alarmLogGroupReq, BaseListResp<AlarmLogGroupData> baseListResp) {
        List<AlarmLogGroupData> alarmLogGroupData = this.alarmLogMapper.queryAlarmLogGroup();
        baseListResp.setData(alarmLogGroupData);
        return baseListResp;
    }
}
