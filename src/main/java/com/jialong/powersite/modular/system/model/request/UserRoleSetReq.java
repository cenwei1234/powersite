package com.jialong.powersite.modular.system.model.request;

public class UserRoleSetReq {

    private Integer userId;

    private String roleIds;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }
}
