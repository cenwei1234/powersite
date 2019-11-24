package com.jialong.powersite.modular.system.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jialong.powersite.modular.system.mapper.UserMapper;
import com.jialong.powersite.modular.system.model.User;
import com.jialong.powersite.modular.system.model.request.UserLoginReq;
import com.jialong.powersite.modular.system.model.request.UserRegReq;
import com.jialong.powersite.modular.system.model.request.UserResetReq;
import com.jialong.powersite.modular.system.model.request.UserRoleSetReq;
import com.jialong.powersite.modular.system.model.response.UserLoginResp;
import com.jialong.powersite.modular.system.model.response.UserRegResp;
import com.jialong.powersite.modular.system.model.response.UserResetResp;
import com.jialong.powersite.modular.system.model.response.UserRoleSetResp;
import com.jialong.powersite.modular.system.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public UserLoginResp loginValid(UserLoginReq userLoginRequest, UserLoginResp userLoginResp) {
        String username = userLoginRequest.getUsername();
        String password = userLoginRequest.getPassword();

        //用户名验证
        if (userMapper.userNameValid(username) == 0)
        {
            //说明用户不存在
            userLoginResp.setErrorCode("1");
            userLoginResp.setErrorMsg("用户不存在");
            return userLoginResp;
        }

        User user = userMapper.queryUserByUserName(username);
        //密码验证
        //说明已经找到用户，接下来校验密码
        String md5Passwd = DigestUtils.md5Hex(password);
        if(!StringUtils.equals(md5Passwd, user.getPassword())){
            //说明密码不正确
            userLoginResp.setErrorCode("1");
            userLoginResp.setErrorMsg("password error");
            return userLoginResp;
        }
        //生成token
        String token = DigestUtils.md5Hex(System.currentTimeMillis() + "" +user.getUsername());
        userLoginResp.setToken(token);
        return userLoginResp;
    }

    /**
     * 用户注册
     * @param userRegReq
     * @return
     */
    public UserRegResp register(UserRegReq userRegReq, UserRegResp userRegResp) {
        User user = new User();
        String md5Passwd = DigestUtils.md5Hex(userRegReq.getPassword());
        user.setPassword(md5Passwd);
        user.setUsername(userRegReq.getUsername());
        if (!this.userMapper.insertUser(userRegReq.getUsername(),userRegReq.getPassword()))
        {
            userRegResp.setErrorCode("-1");
            userRegResp.setErrorMsg("注册失败");
        }
        return userRegResp;
    }

    /**
     * 重置密码接口
     * @param userResetReq
     * @param userResetResp
     * @return
     */
    public UserResetResp resetPwd(UserResetReq userResetReq, UserResetResp userResetResp) {
        String md5Passwd = DigestUtils.md5Hex(userResetReq.getNewpassword());
        if (!this.userMapper.resetUserPwd(userResetReq.getUsername(),md5Passwd))
        {
            userResetResp.setErrorCode("-1");
            userResetResp.setErrorMsg("注册失败");
        }
        return userResetResp;
    }

    public UserRoleSetResp setUserRole(UserRoleSetReq userRoleSetReq, UserRoleSetResp userRoleSetResp)
    {
        Integer userId = userRoleSetReq.getUserid();
        String roleIds = userRoleSetReq.getRoleids();
        this.userMapper.setRoles(userId, roleIds);
        return userRoleSetResp;
    }

}
