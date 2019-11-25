package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.response.data.LoginTokenData;

public class UserLoginResp extends BaseResp{

    private LoginTokenData data;

    public LoginTokenData getData() {
        return data;
    }

    public void setData(LoginTokenData data) {
        this.data = data;
    }
}
