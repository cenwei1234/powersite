package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.core.utils.Pagination;
import com.jialong.powersite.modular.system.mapper.AlarmLogMapper;
import com.jialong.powersite.modular.system.model.JlAlarmLog;
import com.jialong.powersite.modular.system.model.JlAlarmLogQueryData;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.response.AlarmLogListResp;
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

        List<AlarmLogRespData> jlAlarmLogs = alarmLogMapper.queryAlarmLogList(jlAlarmLogQueryData);
        int totalCount = alarmLogMapper.queryAlarmLogCount(jlAlarmLogQueryData);
        alarmLogListResp.setTotalCount(totalCount);
        alarmLogListResp.setData(jlAlarmLogs);
        return alarmLogListResp;
    }
}
