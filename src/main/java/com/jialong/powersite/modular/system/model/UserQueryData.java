package com.jialong.powersite.modular.system.model;

import com.jialong.powersite.core.utils.Pagination;

public class UserQueryData extends Pagination {

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
