package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.response.data.WorkSheetRecordRespData;

import java.util.List;

public class WorkSheetListResp extends BaseResp {
    private List<WorkSheetRecordRespData> data;

    public List<WorkSheetRecordRespData> getData() {
        return data;
    }

    public void setData(List<WorkSheetRecordRespData> data) {
        this.data = data;
    }
}
