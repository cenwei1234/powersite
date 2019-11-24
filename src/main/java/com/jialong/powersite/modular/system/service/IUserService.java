package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.UserLoginReq;
import com.jialong.powersite.modular.system.model.request.UserRegReq;
import com.jialong.powersite.modular.system.model.request.UserResetReq;
import com.jialong.powersite.modular.system.model.request.UserRoleSetReq;
import com.jialong.powersite.modular.system.model.response.UserLoginResp;
import com.jialong.powersite.modular.system.model.response.UserRegResp;
import com.jialong.powersite.modular.system.model.response.UserResetResp;
import com.jialong.powersite.modular.system.model.response.UserRoleSetResp;

public interface IUserService {

    UserLoginResp loginValid(UserLoginReq userLoginRequest, UserLoginResp userLoginResp);

    UserRegResp register(UserRegReq userRegReq, UserRegResp userRegResp);

    UserResetResp resetPwd(UserResetReq userResetReq, UserResetResp userResetResp);

    UserRoleSetResp setUserRole(UserRoleSetReq userRoleSetReq, UserRoleSetResp userRoleSetResp);
}
