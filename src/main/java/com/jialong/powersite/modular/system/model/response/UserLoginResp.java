package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.response.data.UserLoginRespData;

public class UserLoginResp extends BaseResp{

    private UserLoginRespData data;

    public UserLoginRespData getData() {
        return data;
    }

    public void setData(UserLoginRespData data) {
        this.data = data;
    }
}
