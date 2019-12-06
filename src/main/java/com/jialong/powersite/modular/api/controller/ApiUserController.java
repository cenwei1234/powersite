package com.jialong.powersite.modular.api.controller;

import com.jialong.powersite.modular.system.model.User;
import com.jialong.powersite.modular.system.model.request.ApiUserPwResetReq;
import com.jialong.powersite.modular.system.model.request.UserDetailQueryReq;
import com.jialong.powersite.modular.system.model.response.BaseBeanResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
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
    public BaseBeanResp userProfile(@RequestBody UserDetailQueryReq userDetailQueryReq) {
        BaseBeanResp<User> baseBeanResp = new BaseBeanResp<>();
        return userService.queryUserById(userDetailQueryReq, baseBeanResp);
    }

    @RequestMapping(value = "/resetpwd", method = RequestMethod.POST)
    public BaseResp userPwdReset(@RequestBody ApiUserPwResetReq apiUserPwResetReq)
    {
        BaseResp baseResp = new BaseResp();
        return userService.updateUserPwdForClient(apiUserPwResetReq, baseResp);
    }

}
