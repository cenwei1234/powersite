package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper{

    Integer userNameValid(@Param("username") String username);

    User queryUserByUserName(@Param("username") String username);

    Boolean updateTokenByUserId(@Param("token") String token, @Param("salt") String salt, @Param("userId") Integer userId);

    User queryUserByToken(@Param("token") String token);

    Boolean insertUser(User user);

    Boolean resetUserPwd(@Param("username") String username, @Param("password") String password);

    User queryUserById(@Param("userId") Integer userId);

    int setRoles(@Param("userId") Integer userId, @Param("roleIds") String roleIds);
}