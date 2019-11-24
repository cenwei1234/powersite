package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.modular.system.model.Role;

import java.util.List;

public class RoleListResp extends BaseResp {

    private List<Role> data;

    public List<Role> getData() {
        return data;
    }

    public void setData(List<Role> data) {
        this.data = data;
    }
}
