package com.jialong.powersite.modular.system.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jialong.powersite.modular.system.model.JlAlarmLog;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlarmLogListResp extends BaseResp {

    private List<JlAlarmLog> data;

    public List<JlAlarmLog> getData() {
        return data;
    }

    public void setData(List<JlAlarmLog> data) {
        this.data = data;
    }
}
