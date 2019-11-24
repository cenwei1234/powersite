package com.jialong.powersite.modular.system.model.request;

public class UserRoleSetReq {

    private Integer userid;

    private String roleids;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRoleids() {
        return roleids;
    }

    public void setRoleids(String roleids) {
        this.roleids = roleids;
    }
}
