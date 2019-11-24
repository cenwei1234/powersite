package com.jialong.powersite.modular.system.model.request;

public class UserResetReq {

    private String username;

    private String newpassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    @Override
    public String toString() {
        return "UserResetReq{" +
                "username='" + username + '\'' +
                ", newpassword='" + newpassword + '\'' +
                '}';
    }
}
