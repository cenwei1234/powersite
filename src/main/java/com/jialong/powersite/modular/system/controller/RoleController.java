package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;
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
    public RoleListResp queryRoleList(@RequestBody RoleListReq roleListReq)
    {
        RoleListResp roleListResp = new RoleListResp();
        return this.roleService.queryRoleList(roleListReq, roleListResp);
    }

    @RequestMapping("/add")
    public RoleAddResp addRoleList(@RequestBody RoleAddReq roleAddReq)
    {
        RoleAddResp roleAddResp = new RoleAddResp();
        return this.roleService.addRole(roleAddReq, roleAddResp);
    }

    @RequestMapping("/update")
    public RoleUpdateResp updateRole(@RequestBody RoleUpdateReq roleUpdateReq)
    {
        RoleUpdateResp roleUpdateResp = new RoleUpdateResp();
        return this.roleService.updateRole(roleUpdateReq, roleUpdateResp);
    }

    @RequestMapping("/del")
    public RoleDelResp delRoleList(@RequestBody RoleDelReq roleDelReq)
    {
        RoleDelResp roleDelResp = new RoleDelResp();
        return this.roleService.delRoleById(roleDelReq, roleDelResp);
    }


    @RequestMapping("/queryrolemenu")
    public RoleMenuListResp queryRoleMenu(@RequestBody RoleMenuListReq roleMenuListReq)
    {
        RoleMenuListResp roleMenuListResp = new RoleMenuListResp();
        return this.menuService.getRoleMenuList(roleMenuListReq,roleMenuListResp);
    }

    @RequestMapping("/setrolemenu")
    public RoleMenuSetResp selectUserRole(@RequestBody RoleMenuSetReq roleMenuSetReq)
    {
        RoleMenuSetResp roleMenuSetResp = new RoleMenuSetResp();
        return this.roleService.setAuthority(roleMenuSetReq, roleMenuSetResp);
    }

}
