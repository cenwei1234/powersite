package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.response.data.CheckTaskRespData;

import java.util.List;

public class CheckTaskListResp extends BaseResp {

    private List<CheckTaskRespData> data;

    public List<CheckTaskRespData> getData() {
        return data;
    }

    public void setData(List<CheckTaskRespData> data) {
        this.data = data;
    }
}
