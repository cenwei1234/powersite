package com.jialong.powersite.modular.system.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jialong.powersite.modular.system.model.JlAlarmLog;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogRespData;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlarmLogListResp extends BaseResp {

    private List<AlarmLogRespData> data;

    public List<AlarmLogRespData> getData() {
        return data;
    }

    public void setData(List<AlarmLogRespData> data) {
        this.data = data;
    }
}
