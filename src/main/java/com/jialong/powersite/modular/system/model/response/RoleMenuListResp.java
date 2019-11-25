package com.jialong.powersite.modular.system.model.response;

import com.jialong.powersite.core.common.node.ZTreeNode;

import java.util.List;

public class RoleMenuListResp {

    private List<ZTreeNode> data;

    public List<ZTreeNode> getData() {
        return data;
    }

    public void setData(List<ZTreeNode> data) {
        this.data = data;
    }
}
