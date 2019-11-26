package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.response.data.OperationRecordRespData;

import java.util.List;

public class OperationRecordListResp extends BaseResp {

    private List<OperationRecordRespData> data;

    public List<OperationRecordRespData> getData() {
        return data;
    }

    public void setData(List<OperationRecordRespData> data) {
        this.data = data;
    }
}
