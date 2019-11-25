package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.core.common.constant.state.UserStatus;
import com.jialong.powersite.core.exception.BizExceptionEnum;
import com.jialong.powersite.core.utils.ToolUtil;
import com.jialong.powersite.modular.system.mapper.UserMapper;
import com.jialong.powersite.modular.system.model.User;
import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;
import com.jialong.powersite.modular.system.model.response.data.LoginTokenData;
import com.jialong.powersite.modular.system.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public UserLoginResp loginValid(UserLoginReq userLoginRequest, HttpSession httpSession, UserLoginResp userLoginResp) {
        String username = userLoginRequest.getUsername();
        String password = userLoginRequest.getPassword();

        if (userMapper.userNameValid(username) == 0)
        {
            userLoginResp.setErrorCode(String.valueOf(BizExceptionEnum.USER_NOT_EXISTED.getCode()));
            userLoginResp.setErrorMsg(BizExceptionEnum.USER_NOT_EXISTED.getMessage());
            return userLoginResp;
        }

        User user = userMapper.queryUserByUserName(username);
        //密码验证
        //说明已经找到用户，接下来校验密码
        String md5Passwd = DigestUtils.md5Hex(password);
        if(!StringUtils.equals(md5Passwd, user.getPassword())){
            //说明密码不正确
            userLoginResp.setErrorCode(String.valueOf(BizExceptionEnum.PWD_NOT_RIGHT.getCode()));
            userLoginResp.setErrorMsg(BizExceptionEnum.PWD_NOT_RIGHT.getMessage());
            return userLoginResp;
        }
        //生成token
        String randomSalt = ToolUtil.getRandomString(6);
        String token = DigestUtils.md5Hex( randomSalt + "" + user.getUsername());
        //更新数据库的token以及salt
        userMapper.updateTokenByUserId(token, randomSalt, user.getId());
        //保存token到session并且设置有效期
        httpSession.setAttribute(userLoginRequest.getUsername(), token);
        httpSession.setMaxInactiveInterval(3600);
        LoginTokenData loginTokenData = new LoginTokenData();
        loginTokenData.setToken(token);
        userLoginResp.setData(loginTokenData);
        return userLoginResp;
    }

    public UserRegResp register(UserRegReq userRegReq, UserRegResp userRegResp) {
        String username = userRegReq.getUsername();
        //用户名验证
        if (userMapper.userNameValid(username) == 1)
        {
            userRegResp.setErrorCode(String.valueOf(BizExceptionEnum.USER_ALREADY_REG.getCode()));
            userRegResp.setErrorMsg(BizExceptionEnum.USER_ALREADY_REG.getMessage());
            return userRegResp;
        }
        User user = new User();
        String md5Passwd = DigestUtils.md5Hex(userRegReq.getPassword());
        user.setPassword(md5Passwd);
        user.setUsername(username);
        //状态默认为启用
        user.setStatus(UserStatus.ENABLE.getCode());
        user.setCreatetime(new Date());
        if (!this.userMapper.insertUser(user))
        {
            userRegResp.setErrorCode(String.valueOf(BizExceptionEnum.USER_ADD_FAILED.getCode()));
            userRegResp.setErrorMsg(BizExceptionEnum.USER_ADD_FAILED.getMessage());
        }
        return userRegResp;
    }


    public UserResetResp resetPwd(UserResetReq userResetReq, UserResetResp userResetResp) {
        String md5Passwd = DigestUtils.md5Hex(userResetReq.getNewpassword());
        if (!this.userMapper.resetUserPwd(userResetReq.getUsername(), md5Passwd))
        {
            userResetResp.setErrorCode(String.valueOf(BizExceptionEnum.USER_RESET_FAILED.getCode()));
            userResetResp.setErrorMsg(BizExceptionEnum.USER_RESET_FAILED.getMessage());
        }
        return userResetResp;
    }

    public UserRoleSetResp setUserRole(UserRoleSetReq userRoleSetReq, UserRoleSetResp userRoleSetResp)
    {
        Integer userId = userRoleSetReq.getUserId();
        String roleIds = userRoleSetReq.getRoleIds();
        this.userMapper.setRoles(userId, roleIds);
        return userRoleSetResp;
    }

    @Override
    public UserLogoutResp logout(UserLogoutReq userLogoutReq, HttpSession httpSession, UserLogoutResp userLogoutResp) {
        //重置token以及salt
        this.userMapper.updateTokenByUserId(null, null, userLogoutReq.getId());
        //清空session
        httpSession.setAttribute(userLogoutReq.getUsername(), null);
        return userLogoutResp;
    }

}
