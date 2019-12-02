package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.response.data.UserListRespData;

import java.util.List;

public class UserListResp extends BaseResp{

    private List<UserListRespData> data;

    public List<UserListRespData> getData() {
        return data;
    }

    public void setData(List<UserListRespData> data) {
        this.data = data;
    }
}
