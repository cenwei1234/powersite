package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;
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
    public UserLoginResp doLogin(@RequestBody UserLoginReq userLoginRequest, HttpSession httpSession, HttpServletResponse response) {
        UserLoginResp userLoginResp = new UserLoginResp();
        return userService.loginValid(userLoginRequest, httpSession, response, userLoginResp);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public UserListResp queryUsers(@RequestBody UserListReq userListReq)
    {
        UserListResp userListResp = new UserListResp();
        return userService.queryUsers(userListReq, userListResp);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public UserRegResp doRegister(@RequestBody UserRegReq userRegReq) {
        UserRegResp userRegResp = new UserRegResp();
        return userService.register(userRegReq, userRegResp);
    }

    @RequestMapping(value = "/resetpwd", method = RequestMethod.POST)
    public UserResetResp resetPwd(@RequestBody UserResetReq userResetReq) {
        UserResetResp userResetResp = new UserResetResp();
        return userService.resetPwd(userResetReq, userResetResp);
    }

    @RequestMapping(value = "/setuserrole", method = RequestMethod.POST)
    public UserRoleSetResp setUserRole(@RequestBody UserRoleSetReq userRoleSetReq) {
        UserRoleSetResp userRoleSetResp = new UserRoleSetResp();
        userService.setUserRole(userRoleSetReq,userRoleSetResp);
        return userRoleSetResp;
    }

    @RequestMapping("/queryuserrole")
    public UserRoleListResp selectUserRole(@RequestBody UserRoleListReq userRoleReq)
    {
        UserRoleListResp userRoleResp = new UserRoleListResp();
        return this.roleService.roleTreeListByUserId(userRoleReq, userRoleResp);
    }

    @RequestMapping("/logout")
    public UserLogoutResp logout(@RequestBody UserLogoutReq userLogoutReq, HttpSession httpSession)
    {
        UserLogoutResp userLogoutResp = new UserLogoutResp();
        userService.logout(userLogoutReq, httpSession, userLogoutResp);
        return userLogoutResp;
    }
}
