package com.jialong.powersite.modular.system.service;

import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.modular.system.model.Menu;
import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.BaseListResp;
import com.jialong.powersite.modular.system.model.response.BaseResp;
import org.springframework.transaction.annotation.Transactional;

public interface IMenuService {

    BaseListResp selectMenus(MenuListReq menuListReq, BaseListResp<Menu> baseListResp);

    BaseResp insetMenus(MenuAddReq menuAddReq, BaseResp baseResp);

    BaseResp updateMenus(MenuUpdateReq menuUpdateReq, BaseResp baseResp);

    @Transactional
    BaseResp delMenus(MenuDelReq menuDelReq, BaseResp baseResp);

    @Transactional
    void delMenu(Long menuId);

    BaseListResp getRoleMenuList(RoleMenuListReq roleMenuListReq, BaseListResp<ZTreeNode> baseListResp);
}
