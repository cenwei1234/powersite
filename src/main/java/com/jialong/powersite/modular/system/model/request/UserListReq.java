package com.jialong.powersite.modular.system.model.request;

import com.jialong.powersite.core.utils.Page;
import com.jialong.powersite.modular.system.model.User;

public class UserListReq extends Page<User> {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserLoginRequest{" +
                "username='" + username + '\'' +
                '}';
    }
}
