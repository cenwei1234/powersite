package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.modular.system.model.RegionSite;
import com.jialong.powersite.modular.system.model.Role;
import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;
import com.jialong.powersite.modular.system.model.response.data.RoleListRespData;
import com.jialong.powersite.modular.system.model.response.data.UserListRespData;
import com.jialong.powersite.modular.system.service.impl.MenuServiceImpl;
import com.jialong.powersite.modular.system.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin/role")
@RestController
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private MenuServiceImpl menuService;

    @RequestMapping("/list")
    public BaseListResp queryRoleList(@RequestBody RoleListReq roleListReq)
    {
        BaseListResp<RoleListRespData> baseListResp = new BaseListResp<>();
        return this.roleService.queryRoleList(roleListReq, baseListResp);
    }

    @RequestMapping("/add")
    public BaseResp addRoleList(@RequestBody RoleAddReq roleAddReq)
    {
        BaseResp baseResp = new BaseResp();
        return this.roleService.addRole(roleAddReq, baseResp);
    }

    @RequestMapping("/update")
    public BaseResp updateRole(@RequestBody RoleUpdateReq roleUpdateReq)
    {
        BaseResp baseResp = new BaseResp();
        return this.roleService.updateRole(roleUpdateReq, baseResp);
    }

    @RequestMapping("/del")
    public BaseResp delRoleList(@RequestBody RoleDelReq roleDelReq)
    {
        BaseResp baseResp = new BaseResp();
        return this.roleService.delRoleById(roleDelReq, baseResp);
    }


    @RequestMapping("/queryrolemenu")
    public BaseListResp queryRoleMenu(@RequestBody RoleMenuListReq roleMenuListReq)
    {
        BaseListResp<ZTreeNode> baseListResp = new BaseListResp<>();
        return this.menuService.getRoleMenuList(roleMenuListReq,baseListResp);
    }

    @RequestMapping("/setrolemenu")
    public BaseResp selectUserRole(@RequestBody RoleMenuSetReq roleMenuSetReq)
    {
        BaseResp baseResp = new BaseResp();
        return this.roleService.setAuthority(roleMenuSetReq, baseResp);
    }

}
