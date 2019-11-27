package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface IUserService {

    UserLoginResp loginValid(UserLoginReq userLoginRequest, HttpSession httpSession, HttpServletResponse response, UserLoginResp userLoginResp);

    UserRegResp register(UserRegReq userRegReq, UserRegResp userRegResp);

    UserResetResp resetPwd(UserResetReq userResetReq, UserResetResp userResetResp);

    UserRoleSetResp setUserRole(UserRoleSetReq userRoleSetReq, UserRoleSetResp userRoleSetResp);

    UserLogoutResp logout(UserLogoutReq userLogoutReq, HttpSession httpSession, UserLogoutResp userLogoutResp);
}
