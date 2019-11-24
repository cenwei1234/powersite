package com.jialong.powersite.modular.system.model.request;

public class RoleMenuSetReq {

    private Integer roleId;

    private String menuIds;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }
}
