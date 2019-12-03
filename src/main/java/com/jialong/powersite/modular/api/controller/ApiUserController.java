package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.request.ApiUserPwResetReq;
import com.jialong.powersite.modular.system.model.request.UserDetailQueryReq;
import com.jialong.powersite.modular.system.model.response.ApiUserPwResetResp;
import com.jialong.powersite.modular.system.model.response.UserDetailQueryResp;
import com.jialong.powersite.modular.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public UserDetailQueryResp userProfile(@RequestBody UserDetailQueryReq userDetailQueryReq) {
        UserDetailQueryResp userDetailQueryResp = new UserDetailQueryResp();
        return userService.queryUserById(userDetailQueryReq, userDetailQueryResp);
    }

    @RequestMapping(value = "/resetpwd", method = RequestMethod.POST)
    public ApiUserPwResetResp userPwdReset(@RequestBody ApiUserPwResetReq apiUserPwResetReq)
    {
        ApiUserPwResetResp apiUserPwResetResp = new ApiUserPwResetResp();
        return userService.updateUserPwdForClient(apiUserPwResetReq, apiUserPwResetResp);
    }

}
