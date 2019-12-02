package com.jialong.powersite.modular.system.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jialong.powersite.core.common.node.ZTreeNode;

import java.util.List;

public class UserRoleListResp extends BaseResp {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ZTreeNode> data;

    public List<ZTreeNode> getData() {
        return data;
    }

    public void setData(List<ZTreeNode> data) {
        this.data = data;
    }
}
