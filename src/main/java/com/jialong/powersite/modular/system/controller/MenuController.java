package com.jialong.powersite.modular.system.controller;

import com.jialong.powersite.core.common.node.MenuNode;
import com.jialong.powersite.modular.system.model.Menu;
import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;
import com.jialong.powersite.modular.system.model.response.data.CheckTaskRespData;
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
    public BaseListResp queryMenuList(@RequestBody MenuListReq menuListReq)
    {
        BaseListResp<Menu> baseListResp = new BaseListResp<>();
        menuService.selectMenus(menuListReq, baseListResp);
        return baseListResp;
    }

    @RequestMapping("/add")
    public BaseResp addMenu(@RequestBody MenuAddReq menuAddReq)
    {
        BaseResp baseResp = new BaseResp();
        menuService.insetMenus(menuAddReq, baseResp);
        return baseResp;
    }

    @RequestMapping("/update")
    public BaseResp updateMenu(@RequestBody MenuUpdateReq menuUpdateReq)
    {
        BaseResp baseResp = new BaseResp();
        menuService.updateMenus(menuUpdateReq, baseResp);
        return baseResp;
    }

    @RequestMapping("/del")
    public BaseResp delMenu(@RequestBody MenuDelReq menuDelReq)
    {
        BaseResp baseResp = new BaseResp();
        menuService.delMenus(menuDelReq, baseResp);
        return baseResp;
    }

    @RequestMapping("/menulist")
    public BaseListResp delMenu(@RequestBody MenusListReq menusListReq)
    {
        BaseListResp<MenuNode> baseListResp = new BaseListResp<>();
        return menuService.getMenusByRoleIds(menusListReq, baseListResp);
    }
}
