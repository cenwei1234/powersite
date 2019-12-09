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
import java.util.Objects;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public BaseBeanResp loginValid(UserLoginReq userLoginRequest, HttpSession httpSession, HttpServletResponse response, BaseBeanResp<UserLoginRespData> baseBeanResp) {
        String username = userLoginRequest.getUsername();
        String password = userLoginRequest.getPassword();
        String remember = userLoginRequest.getRemember();

        if (userMapper.userNameValid(username) == 0)
        {
            baseBeanResp.setErrorCode(String.valueOf(BizExceptionEnum.USER_NOT_EXISTED.getCode()));
            baseBeanResp.setErrorMsg(BizExceptionEnum.USER_NOT_EXISTED.getMessage());
            return baseBeanResp;
        }

        UserLoginRespData user = userMapper.queryUserByUserName(username);
        //密码验证
        //说明已经找到用户，接下来校验密码
        String md5Passwd = DigestUtils.md5Hex(password);
        if(!StringUtils.equals(md5Passwd, user.getPassword())){
            //说明密码不正确
            baseBeanResp.setErrorCode(String.valueOf(BizExceptionEnum.PWD_NOT_RIGHT.getCode()));
            baseBeanResp.setErrorMsg(BizExceptionEnum.PWD_NOT_RIGHT.getMessage());
            return baseBeanResp;
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
        baseBeanResp.setData(user);
        return baseBeanResp;
    }

    public BaseListResp queryUsers(UserListReq userListReq, BaseListResp<UserListRespData> baseListResp)
    {
        UserQueryData userQueryData = new UserQueryData();
        userQueryData.setUsername(userListReq.getUsername());
        userQueryData.setStart(userListReq.getStart(userListReq.getPageNo()));
        userQueryData.setPageSize(userListReq.getPageSize());
        List<UserListRespData> users = this.userMapper.queryUserList(userQueryData);
        Integer totalCount = this.userMapper.queryUserListCount(userQueryData);
        baseListResp.setData(users);
        baseListResp.setTotalCount(totalCount);
        return baseListResp;
    }

    public BaseResp register(UserRegReq userRegReq, BaseResp baseResp) {
        if (!userRegReq.getPassword().equals(userRegReq.getRePassword()))
        {
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.TWO_PWD_NOT_MATCH.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.TWO_PWD_NOT_MATCH.getMessage());
            return baseResp;
        }

        String username = userRegReq.getUsername();
        //用户名验证
        if (userMapper.userNameValid(username) == 1)
        {
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.USER_ALREADY_REG.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.USER_ALREADY_REG.getMessage());
            return baseResp;
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
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.USER_ADD_FAILED.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.USER_ADD_FAILED.getMessage());
        }
        return baseResp;
    }


    @Override
    public BaseResp removeUser(UserRemoveReq userRemoveReq, BaseResp baseResp) {
        this.userMapper.removeUser(userRemoveReq.getUserId());
        return baseResp;
    }

    public BaseResp modifyUser(UserModifyReq userModifyReq, BaseResp baseResp) {
        //不能修改超级管理员
        if (Constant.ADMIN_NAME.equals(userModifyReq.getUsername()) || Constant.ADMIN_ID.equals(userModifyReq.getId())) {
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.PARAM_ERROR.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.PARAM_ERROR.getMessage());
        }
        //id没传 则参数错误
        if (Objects.isNull(userModifyReq.getId()))
        {
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.PARAM_ERROR.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.PARAM_ERROR.getMessage());
        }

        User user = new User();
        user.setId(userModifyReq.getId());
        user.setUsername(userModifyReq.getUsername());
        user.setSex(userModifyReq.getSex());
        user.setEmail(userModifyReq.getEmail());
        user.setName(userModifyReq.getName());
        user.setBirthday(userModifyReq.getBirthday());
        user.setDeptid(userModifyReq.getDeptid());
        user.setRoleid(userModifyReq.getRoleid());
        user.setPhone(userModifyReq.getPhone());
        this.userMapper.modifyUser(user);
        return baseResp;
    }

    public BaseResp resetPwd(UserResetReq userResetReq, BaseResp baseResp) {
        //不能修改超级管理员
        if (Constant.ADMIN_ID.equals(userResetReq.getId())) {
            throw new ServiceException(BizExceptionEnum.CANT_CHANGE_ADMIN);
        }
        String md5Passwd = DigestUtils.md5Hex(Constant.DEFAULT_RESET_PASSWRD);
        if (!this.userMapper.resetUserPwd(userResetReq.getId(), md5Passwd))
        {
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.USER_RESET_FAILED.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.USER_RESET_FAILED.getMessage());
        }
        return baseResp;
    }

    public BaseResp setUserRole(UserRoleSetReq userRoleSetReq, BaseResp baseResp)
    {
        Integer userId = userRoleSetReq.getUserId();
        String roleIds = userRoleSetReq.getRoleIds();
        this.userMapper.setRoles(userId, roleIds);
        return baseResp;
    }

    @Override
    public BaseResp logout(UserLogoutReq userLogoutReq, HttpSession httpSession, BaseResp baseResp) {
        //重置token以及salt 更新token以及salt为null.这样再访问其他接口会提示token不合法
        this.userMapper.updateTokenByUserId(null, null, userLogoutReq.getId());
        //清空session
        httpSession.setAttribute(userLogoutReq.getUsername(), null);
        httpSession.setMaxInactiveInterval(0);
        return baseResp;
    }

    @Override
    public BaseBeanResp queryUserById(UserDetailQueryReq userDetailQueryReq, BaseBeanResp<User> baseBeanResp) {
        User user = this.userMapper.queryUserById(userDetailQueryReq.getId());
        baseBeanResp.setData(user);
        return baseBeanResp;
    }

    @Override
    public BaseResp updateUserPwdForClient(ApiUserPwResetReq apiUserPwResetReq, BaseResp baseResp) {
        if (!apiUserPwResetReq.getNewpassword1().equals(apiUserPwResetReq.getNewpassword2()))
        {
            baseResp.setErrorCode(String.valueOf(BizExceptionEnum.TWO_PWD_NOT_MATCH.getCode()));
            baseResp.setErrorMsg(BizExceptionEnum.TWO_PWD_NOT_MATCH.getMessage());
            return baseResp;
        }
        String md5PassWd = DigestUtils.md5Hex(apiUserPwResetReq.getPassword());
        userMapper.resetUserPwd(apiUserPwResetReq.getId(),md5PassWd);
        return baseResp;
    }

}
