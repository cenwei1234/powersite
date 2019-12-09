package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.User;
import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import com.jialong.powersite.modular.system.model.response.data.UserListRespData;
import com.jialong.powersite.modular.system.model.response.data.UserLoginRespData;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface IUserService {

    BaseBeanResp loginValid(UserLoginReq userLoginRequest, HttpSession httpSession, HttpServletResponse response, BaseBeanResp<UserLoginRespData> baseBeanResp);

    BaseListResp queryUsers(UserListReq userListReq, BaseListResp<UserListRespData> baseListResp);

    BaseResp register(UserRegReq userRegReq, BaseResp baseResp);

    BaseResp removeUser(UserRemoveReq userRemoveReq, BaseResp baseResp);

    BaseResp modifyUser(UserModifyReq userModifyReq, BaseResp baseResp);

    BaseResp resetPwd(UserResetReq userResetReq, BaseResp baseResp);

    BaseResp setUserRole(UserRoleSetReq userRoleSetReq, BaseResp baseResp);

    BaseResp logout(UserLogoutReq userLogoutReq, HttpSession httpSession, BaseResp baseResp);

    BaseBeanResp queryUserById(UserDetailQueryReq userDetailQueryReq, BaseBeanResp<User> baseBeanResp);

    BaseResp updateUserPwdForClient(ApiUserPwResetReq apiUserPwResetReq, BaseResp baseResp);
}
