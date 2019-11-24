/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-07-11
 */
@Repository
public interface UserMapper{


    /**
     * 删除某个角色的所有权限
     *
     * @param username 角色id
     * @return
     * @date 2017年2月13日 下午7:57:51
     */
    Integer userNameValid(@Param("username") String username);

    /**
     * 删除某个角色的所有权限
     *
     * @param username 角色id
     * @return
     * @date 2017年2月13日 下午7:57:51
     */
    User queryUserByUserName(@Param("username") String username);

    /**
     * 删除某个角色的所有权限
     *
     * @param token
     * @return
     * @date 2017年2月13日 下午7:57:51
     */
    User queryUserByToken(@Param("token") String token);


    /**
     * 删除某个角色的所有权限
     *
     * @param username
     * @param password
     * @return
     * @date 2017年2月13日 下午7:57:51
     */
    Boolean insertUser(@Param("username") String username, @Param("password") String password);

    /**
     * 删除某个角色的所有权限
     *
     * @param username
     * @param password
     * @return
     * @date 2017年2月13日 下午7:57:51
     */
    Boolean resetUserPwd(@Param("username") String username, @Param("password") String password);

    User queryUserById(@Param("userId") Integer userId);


    /**
     * 设置用户的角色
     */
    int setRoles(@Param("userId") Integer userId, @Param("roleIds") String roleIds);
}