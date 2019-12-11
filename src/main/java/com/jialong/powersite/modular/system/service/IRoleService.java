package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.RoleListRespData;

import java.util.List;


public interface IRoleService{

    BaseListResp queryRoleList(RoleListReq roleListReq, BaseListResp<RoleListRespData> baseListResp);

    BaseResp delRoleById(RoleDelReq roleDelReq, BaseResp baseResp);

    BaseResp addRole(RoleAddReq roleAddReq, BaseResp baseResp);

    BaseResp updateRole(RoleUpdateReq roleUpdateReq, BaseResp baseResp);

    BaseListResp roleTreeListByUserId(UserRoleListReq userRoleReq, BaseListResp<ZTreeNode> baseListResp);

    List<ZTreeNode> roleTreeList();

    List<ZTreeNode> roleTreeListByRoleId(String[] roleId);

    BaseResp setAuthority(RoleMenuSetReq roleMenuSetReq, BaseResp baseResp);
}
