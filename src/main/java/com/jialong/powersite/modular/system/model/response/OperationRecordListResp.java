package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.JlOperationRecord;

import java.util.List;

public class OperationRecordListResp extends BaseResp {

    private List<JlOperationRecord> data;

    public List<JlOperationRecord> getData() {
        return data;
    }

    public void setData(List<JlOperationRecord> data) {
        this.data = data;
    }
}
