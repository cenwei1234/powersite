package com.jialong.powersite.modular.system.service.impl;

import com.jialong.powersite.core.common.constant.Constant;
import com.jialong.powersite.core.common.constant.state.UserStatus;
import com.jialong.powersite.core.exception.BizExceptionEnum;
import com.jialong.powersite.core.exception.ServiceException;
import com.jialong.powersite.core.utils.ToolUtil;
import com.jialong.powersite.modular.system.mapper.UserMapper;
import com.jialong.powersite.modular.system.model.User;
import com.jialong.powersite.modular.system.model.UserQueryData;
import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;
import com.jialong.powersite.modular.system.model.response.data.UserListRespData;
import com.jialong.powersite.modular.system.model.response.data.UserLoginRespData;
import com.jialong.powersite.modular.system.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public UserLoginResp loginValid(UserLoginReq userLoginRequest, HttpSession httpSession, HttpServletResponse response, UserLoginResp userLoginResp) {
        String username = userLoginRequest.getUsername();
        String password = userLoginRequest.getPassword();
        String remember = userLoginRequest.getRemember();

        if (userMapper.userNameValid(username) == 0)
        {
            userLoginResp.setErrorCode(String.valueOf(BizExceptionEnum.USER_NOT_EXISTED.getCode()));
            userLoginResp.setErrorMsg(BizExceptionEnum.USER_NOT_EXISTED.getMessage());
            return userLoginResp;
        }

        UserLoginRespData user = userMapper.queryUserByUserName(username);
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
        httpSession.setMaxInactiveInterval(Constant.SESSION_VALIDTIME);
        //记住我
        if ("1".equals(remember))
        {
            Cookie cookieUserName = new Cookie("username", username);
            Cookie cookiePassWord = new Cookie("password", password);
            cookieUserName.setMaxAge(60*60*24*7);
            cookiePassWord.setMaxAge(60*60*24*7);
            response.addCookie(cookieUserName);
            response.addCookie(cookiePassWord);
        }
        userLoginResp.setData(user);
        return userLoginResp;
    }

    public UserListResp queryUsers(UserListReq userListReq, UserListResp userListResp)
    {
        UserQueryData userQueryData = new UserQueryData();
        userQueryData.setUsername(userListReq.getUsername());
        userQueryData.setStart(userListReq.getStart(userListReq.getPageNo()));
        userQueryData.setPageSize(userListReq.getPageSize());
        List<UserListRespData> users = this.userMapper.queryUserList(userQueryData);
        Integer totalCount = this.userMapper.queryUserListCount(userQueryData);
        userListResp.setData(users);
        userListResp.setTotalCount(totalCount);
        return userListResp;
    }

    public UserRegResp register(UserRegReq userRegReq, UserRegResp userRegResp) {
        if (!userRegReq.getPassword().equals(userRegReq.getRePassword()))
        {
            userRegResp.setErrorCode(String.valueOf(BizExceptionEnum.TWO_PWD_NOT_MATCH.getCode()));
            userRegResp.setErrorMsg(BizExceptionEnum.TWO_PWD_NOT_MATCH.getMessage());
            return userRegResp;
        }

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
        user.setSex(userRegReq.getSex());
        user.setAvatar(userRegReq.getAvatar());
        user.setEmail(userRegReq.getEmail());
        user.setName(userRegReq.getName());
        user.setBirthday(userRegReq.getBirthday());
        user.setDeptid(userRegReq.getDeptid());
        user.setRoleid(userRegReq.getRoleid());
        user.setPhone(userRegReq.getPhone());
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
        //不能修改超级管理员
        if (userResetReq.getUsername().equals(Constant.ADMIN_NAME)) {
            throw new ServiceException(BizExceptionEnum.CANT_CHANGE_ADMIN);
        }
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
        //重置token以及salt 更新token以及salt为null.这样再访问其他接口会提示token不合法
        this.userMapper.updateTokenByUserId(null, null, userLogoutReq.getId());
        //清空session
        httpSession.setAttribute(userLogoutReq.getUsername(), null);
        httpSession.setMaxInactiveInterval(0);
        return userLogoutResp;
    }

    @Override
    public UserDetailQueryResp queryUserById(UserDetailQueryReq userDetailQueryReq, UserDetailQueryResp userDetailQueryResp) {
        User user = this.userMapper.queryUserById(userDetailQueryReq.getId());
        userDetailQueryResp.setData(user);
        return userDetailQueryResp;
    }

    @Override
    public ApiUserPwResetResp updateUserPwdForClient(ApiUserPwResetReq apiUserPwResetReq, ApiUserPwResetResp apiUserPwResetResp) {
        if (!apiUserPwResetReq.getNewpassword1().equals(apiUserPwResetReq.getNewpassword2()))
        {
            apiUserPwResetResp.setErrorCode(String.valueOf(BizExceptionEnum.TWO_PWD_NOT_MATCH.getCode()));
            apiUserPwResetResp.setErrorMsg(BizExceptionEnum.TWO_PWD_NOT_MATCH.getMessage());
            return apiUserPwResetResp;
        }
        String md5PassWd = DigestUtils.md5Hex(apiUserPwResetReq.getPassword());
        userMapper.resetUserPwd(apiUserPwResetReq.getUsername(),md5PassWd);
        return apiUserPwResetResp;
    }

}
