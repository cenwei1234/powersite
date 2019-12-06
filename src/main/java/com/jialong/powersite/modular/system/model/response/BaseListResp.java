package com.jialong.powersite.modular.system.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jialong.powersite.modular.system.model.JlAlarmLog;
import com.jialong.powersite.modular.system.model.response.data.AlarmLogRespData;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseListResp<T> extends BaseResp {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
