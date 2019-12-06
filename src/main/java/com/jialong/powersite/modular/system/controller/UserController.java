package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.modular.system.model.User;
import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;
import com.jialong.powersite.modular.system.model.response.data.UserListRespData;
import com.jialong.powersite.modular.system.model.response.data.UserLoginRespData;
import com.jialong.powersite.modular.system.service.IRoleService;
import com.jialong.powersite.modular.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseBeanResp doLogin(@RequestBody UserLoginReq userLoginRequest, HttpSession httpSession, HttpServletResponse response) {
        BaseBeanResp<UserLoginRespData> baseBeanResp = new BaseBeanResp<>();
        return userService.loginValid(userLoginRequest, httpSession, response, baseBeanResp);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public BaseListResp queryUsers(@RequestBody UserListReq userListReq)
    {
        BaseListResp<UserListRespData> baseListResp = new BaseListResp<>();
        return userService.queryUsers(userListReq, baseListResp);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResp doRegister(@RequestBody UserRegReq userRegReq) {
        BaseResp baseResp = new BaseResp();
        return userService.register(userRegReq, baseResp);
    }

    @RequestMapping(value = "/resetpwd", method = RequestMethod.POST)
    public BaseResp resetPwd(@RequestBody UserResetReq userResetReq) {
        BaseResp baseResp = new BaseResp();
        return userService.resetPwd(userResetReq, baseResp);
    }

    @RequestMapping(value = "/setuserrole", method = RequestMethod.POST)
    public BaseResp setUserRole(@RequestBody UserRoleSetReq userRoleSetReq) {
        BaseResp baseResp = new BaseResp();
        userService.setUserRole(userRoleSetReq,baseResp);
        return baseResp;
    }

    @RequestMapping("/queryuserrole")
    public BaseResp selectUserRole(@RequestBody UserRoleListReq userRoleReq)
    {
        BaseListResp<ZTreeNode> baseListResp = new BaseListResp<>();
        return this.roleService.roleTreeListByUserId(userRoleReq, baseListResp);
    }

    @RequestMapping("/logout")
    public BaseResp logout(@RequestBody UserLogoutReq userLogoutReq, HttpSession httpSession)
    {
        BaseResp baseResp = new BaseResp();
        userService.logout(userLogoutReq, httpSession, baseResp);
        return baseResp;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public BaseBeanResp userProfile(@RequestBody UserDetailQueryReq userDetailQueryReq) {
        BaseBeanResp<User> baseBeanResp = new BaseBeanResp<>();
        return userService.queryUserById(userDetailQueryReq, baseBeanResp);
    }
}
