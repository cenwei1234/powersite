package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.JlCheckTask;
import com.jialong.powersite.modular.system.model.JlWorkSheetRecord;

import java.util.List;

public class CheckTaskListResp extends BaseResp {
    private List<JlCheckTask> data;

    public List<JlCheckTask> getData() {
        return data;
    }

    public void setData(List<JlCheckTask> data) {
        this.data = data;
    }
}
