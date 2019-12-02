package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.modular.system.model.request.MenuAddReq;
import com.jialong.powersite.modular.system.model.request.MenuDelReq;
import com.jialong.powersite.modular.system.model.request.MenuListReq;
import com.jialong.powersite.modular.system.model.request.MenuUpdateReq;
import com.jialong.powersite.modular.system.model.response.MenuAddResp;
import com.jialong.powersite.modular.system.model.response.MenuDelResp;
import com.jialong.powersite.modular.system.model.response.MenuListResp;
import com.jialong.powersite.modular.system.model.response.MenuUpdateResp;
import com.jialong.powersite.modular.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/menu")
public class MenuController  {

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/list")
    public MenuListResp queryMenuList(@RequestBody MenuListReq menuListReq)
    {
        MenuListResp menuListResp = new MenuListResp();
        menuService.selectMenus(menuListReq, menuListResp);
        return menuListResp;
    }

    @RequestMapping("/add")
    public MenuAddResp addMenu(@RequestBody MenuAddReq menuAddReq)
    {
        MenuAddResp menuAddResp = new MenuAddResp();
        menuService.insetMenus(menuAddReq, menuAddResp);
        return menuAddResp;
    }

    @RequestMapping("/update")
    public MenuUpdateResp updateMenu(@RequestBody MenuUpdateReq menuUpdateReq)
    {
        MenuUpdateResp menuUpdateResp = new MenuUpdateResp();
        menuService.updateMenus(menuUpdateReq, menuUpdateResp);
        return menuUpdateResp;
    }

    @RequestMapping("/del")
    public MenuDelResp delMenu(@RequestBody MenuDelReq menuDelReq)
    {
        MenuDelResp menuDelResp = new MenuDelResp();
        menuService.delMenus(menuDelReq, menuDelResp);
        return menuDelResp;
    }
}
