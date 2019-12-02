package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.response.data.AlarmLogGroupData;

import java.util.List;

public class AlarmLogGroupResp {

    private List<AlarmLogGroupData> data;

    public List<AlarmLogGroupData> getData() {
        return data;
    }

    public void setData(List<AlarmLogGroupData> data) {
        this.data = data;
    }
}
