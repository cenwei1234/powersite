package com.jialong.powersite.modular.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.jialong.powersite.core.common.constant.state.MenuStatus;
import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.core.exception.ServiceException;
import com.jialong.powersite.core.exception.BizExceptionEnum;
import com.jialong.powersite.modular.system.mapper.MenuMapper;
import com.jialong.powersite.modular.system.model.Menu;
import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;
import com.jialong.powersite.modular.system.service.IMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public MenuListResp selectMenus(MenuListReq menuListReq, MenuListResp menuListResp) {
        List<Menu> menus = menuMapper.selectMenus();
        menuListResp.setData(menus);
        return menuListResp;
    }

    @Override
    public MenuAddResp insetMenus(MenuAddReq menuAddReq, MenuAddResp menuAddResp) {
        /**
         * 根据请求的父级菜单编号设置pcode和层级
         */
        Menu menu = new Menu();
        if (StringUtils.isEmpty(menuAddReq.getPcode()) || menuAddReq.getPcode().equals("0")) {
            menu.setPcode("0");
            menu.setPcodes("[0],");
            menu.setLevels(1);
        } else {
            long code = Long.parseLong(menuAddReq.getPcode());
            Menu pMenu = menuMapper.selectById(code);
            Integer pLevels = pMenu.getLevels();
            menu.setPcode(pMenu.getCode());

            //如果编号和父编号一致会导致无限递归
            if (menuAddReq.getCode().equals(menuAddReq.getPcode())) {
                throw new ServiceException(BizExceptionEnum.MENU_PCODE_COINCIDENCE);
            }

            menu.setLevels(pLevels + 1);
            menu.setPcodes(pMenu.getPcodes() + "[" + pMenu.getCode() + "],");
        }

        menu.setStatus(MenuStatus.ENABLE.getCode());
        //对象转换
        menu.setCode(menuAddReq.getCode());
        menu.setName(menuAddReq.getName());
        menu.setIcon(menuAddReq.getIcon());
        menu.setUrl(menuAddReq.getUrl());
        menu.setNum(menuAddReq.getNum());
        menu.setIsmenu(menuAddReq.getIsmenu());
        menu.setIsopen(menuAddReq.getIsopen());

        menuMapper.insertMenus(menu);
        return menuAddResp;
    }

    @Override
    public MenuUpdateResp updateMenus(MenuUpdateReq menuUpdateReq, MenuUpdateResp menuUpdateResp) {

        Menu menu = new Menu();
        if (StringUtils.isEmpty(menuUpdateReq.getPcode()) || menuUpdateReq.getPcode().equals("0")) {
            menu.setPcode("0");
            menu.setPcodes("[0],");
            menu.setLevels(1);
        } else {
            long code = Long.parseLong(menuUpdateReq.getPcode());
            Menu pMenu = menuMapper.selectById(code);
            Integer pLevels = pMenu.getLevels();
            menu.setPcode(pMenu.getCode());

            //如果编号和父编号一致会导致无限递归
            if (menuUpdateReq.getCode().equals(menuUpdateReq.getPcode())) {
                throw new ServiceException(BizExceptionEnum.MENU_PCODE_COINCIDENCE);
            }

            menu.setLevels(pLevels + 1);
            menu.setPcodes(pMenu.getPcodes() + "[" + pMenu.getCode() + "],");
        }

        menu.setStatus(MenuStatus.ENABLE.getCode());
        //对象转换
        menu.setId(menuUpdateReq.getId());
        menu.setCode(menuUpdateReq.getCode());
        menu.setName(menuUpdateReq.getName());
        menu.setIcon(menuUpdateReq.getIcon());
        menu.setUrl(menuUpdateReq.getUrl());
        menu.setNum(menuUpdateReq.getNum());
        menu.setIsmenu(menuUpdateReq.getIsmenu());
        menu.setIsopen(menuUpdateReq.getIsopen());

        menuMapper.updateMenus(menu);
        return menuUpdateResp;
    }

    @Override
    @Transactional
    public MenuDelResp delMenus(MenuDelReq menuDelReq, MenuDelResp menuDelResp) {
        Menu menu = menuMapper.selectById(menuDelReq.getMenuId());
        //删除当前菜单
        delMenu(menu.getId());
        //删除所有子菜单
        String pcodes = "%[" + menu.getCode() + "]%";
        List<Menu> menus = menuMapper.selectSubMenusLike(pcodes);
        for (Menu temp : menus) {
            delMenu(temp.getId());
        }
        return menuDelResp;
    }

    @Override
    @Transactional
    public void delMenu(Long menuId) {

        //删除菜单
        this.menuMapper.delMenuById(menuId);

        //删除关联的relation
        this.menuMapper.deleteRelationByMenu(menuId);
    }

    @Override
    public RoleMenuListResp getRoleMenuList(RoleMenuListReq roleMenuListReq, RoleMenuListResp roleMenuListResp)
    {
        List<Long> menuIds = this.menuMapper.getMenuIdsByRoleId(roleMenuListReq.getRoleId());
        List<ZTreeNode> zTreeNodeList;
        if (CollectionUtil.isEmpty(menuIds)) {
            zTreeNodeList = this.menuMapper.menuTreeList();
        } else {
            zTreeNodeList = this.menuMapper.menuTreeListByMenuIds(menuIds);
        }
        roleMenuListResp.setData(zTreeNodeList);
        return roleMenuListResp;
    }
}
