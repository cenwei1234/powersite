package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.User;
import com.jialong.powersite.modular.system.model.UserQueryData;
import com.jialong.powersite.modular.system.model.response.data.UserListRespData;
import com.jialong.powersite.modular.system.model.response.data.UserLoginRespData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper{

    Integer userNameValid(@Param("username") String username);

    UserLoginRespData queryUserByUserName(@Param("username") String username);

    Boolean updateTokenByUserId(@Param("token") String token, @Param("salt") String salt, @Param("userId") Integer userId);

    User queryUserByToken(@Param("token") String token);

    Boolean insertUser(User user);

    Boolean removeUser(@Param("userId") Integer userId);

    Boolean modifyUser(User user);

    User queryUserById(@Param("userId") Integer userId);

    List<UserListRespData> queryUserList(UserQueryData userQueryData);

    Integer queryUserListCount(UserQueryData userQueryData);

    int setRoles(@Param("userId") Integer userId, @Param("roleIds") String roleIds);

    Boolean resetUserPwd(@Param("userId") Integer userId, @Param("password") String password);
}