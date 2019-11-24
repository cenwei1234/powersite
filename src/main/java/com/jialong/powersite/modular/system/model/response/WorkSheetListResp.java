package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.JlWorkSheetRecord;

import java.util.List;

public class WorkSheetListResp extends BaseResp {
    private List<JlWorkSheetRecord> data;

    public List<JlWorkSheetRecord> getData() {
        return data;
    }

    public void setData(List<JlWorkSheetRecord> data) {
        this.data = data;
    }
}
