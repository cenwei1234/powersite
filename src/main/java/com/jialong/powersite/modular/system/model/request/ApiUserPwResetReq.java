package com.jialong.powersite.modular.system.model.request;

public class ApiUserPwResetReq {

    private String username;

    private String password;

    private String newpassword1;

    private String getNewpassword2;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpassword1() {
        return newpassword1;
    }

    public void setNewpassword1(String newpassword1) {
        this.newpassword1 = newpassword1;
    }

    public String getGetNewpassword2() {
        return getNewpassword2;
    }

    public void setGetNewpassword2(String getNewpassword2) {
        this.getNewpassword2 = getNewpassword2;
    }
}
