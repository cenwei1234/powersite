package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.core.utils.Page;
import com.jialong.powersite.core.utils.Pagination;
import com.jialong.powersite.modular.system.mapper.AlarmLogMapper;
import com.jialong.powersite.modular.system.model.JlAlarmLog;
import com.jialong.powersite.modular.system.model.request.AlarmLogListReq;
import com.jialong.powersite.modular.system.model.response.AlarmLogListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmLogServiceImpl implements com.jialong.powersite.modular.system.service.IAlarmLogService {

    @Autowired
    private AlarmLogMapper alarmLogMapper;

    @Override
    public AlarmLogListResp queryAlarmLogList(AlarmLogListReq alarmLogListReq, AlarmLogListResp alarmLogListResp)
    {
        Pagination pagination = new Pagination();
        pagination.setStart(alarmLogListReq.getStart(alarmLogListReq.getPageNo()));
        pagination.setPageSize(alarmLogListReq.getPageSize());
        List<JlAlarmLog> jlAlarmLogs = alarmLogMapper.queryAlarmLogList(pagination);
        int totalCount = alarmLogMapper.queryAlarmLogCount();
        alarmLogListResp.setTotalCount(totalCount);
        alarmLogListResp.setData(jlAlarmLogs);
        return alarmLogListResp;
    }
}
