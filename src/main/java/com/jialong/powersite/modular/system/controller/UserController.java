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
package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.UserLoginReq;
import com.jialong.powersite.modular.system.model.request.UserRegReq;
import com.jialong.powersite.modular.system.model.request.UserResetReq;
import com.jialong.powersite.modular.system.model.request.UserRoleSetReq;
import com.jialong.powersite.modular.system.model.response.UserLoginResp;
import com.jialong.powersite.modular.system.model.response.UserRegResp;
import com.jialong.powersite.modular.system.model.response.UserResetResp;
import com.jialong.powersite.modular.system.model.response.UserRoleSetResp;
import com.jialong.powersite.modular.system.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 *
 * @author fengshuonan
 * @Date 2017年1月10日 下午8:25:24
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 登陆接口
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserLoginResp doLogin(@RequestBody UserLoginReq userLoginRequest) {
        UserLoginResp userLoginResp = new UserLoginResp();
        return userService.loginValid(userLoginRequest, userLoginResp);
    }

    /**
     * 创建新用户接口
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public UserRegResp doRegister(@RequestBody UserRegReq userRegReq) {
        UserRegResp userRegResp = new UserRegResp();
        return userService.register(userRegReq, userRegResp);
    }

    /**
     * 重置密码接口
     */
    @ResponseBody
    @RequestMapping(value = "/resetpwd", method = RequestMethod.POST)
    public UserResetResp resetPwd(@RequestBody UserResetReq userResetReq) {
        UserResetResp userResetResp = new UserResetResp();
        return userService.resetPwd(userResetReq, userResetResp);
    }

    @ResponseBody
    @RequestMapping(value = "/setuserrole", method = RequestMethod.POST)
    public UserRoleSetResp setUserRole(@RequestBody UserRoleSetReq userRoleSetReq) {
        UserRoleSetResp userRoleSetResp = new UserRoleSetResp();
        userService.setUserRole(userRoleSetReq,userRoleSetResp);
        return userRoleSetResp;
    }

}
