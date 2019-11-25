package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;
import org.springframework.transaction.annotation.Transactional;

public interface IMenuService {

    MenuListResp selectMenus(MenuListReq menuListReq, MenuListResp menuListResp);

    MenuAddResp insetMenus(MenuAddReq menuAddReq, MenuAddResp menuAddResp);

    MenuUpdateResp updateMenus(MenuUpdateReq menuUpdateReq, MenuUpdateResp menuUpdateResp);

    @Transactional
    MenuDelResp delMenus(MenuDelReq menuDelReq, MenuDelResp menuDelResp);

    @Transactional
    void delMenu(Long menuId);

    RoleMenuListResp getRoleMenuList(RoleMenuListReq roleMenuListReq, RoleMenuListResp roleMenuListResp);
}
