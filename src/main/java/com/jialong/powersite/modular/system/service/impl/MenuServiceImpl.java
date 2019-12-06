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
    public BaseListResp selectMenus(MenuListReq menuListReq, BaseListResp<Menu> baseListResp) {
        List<Menu> menus = menuMapper.selectMenus();
        baseListResp.setData(menus);
        return baseListResp;
    }

    @Override
    public BaseResp insetMenus(MenuAddReq menuAddReq, BaseResp baseResp) {
        /**
         * 根据请求的父级菜单编号设置pcode和层级
         * 这里前段传递过来的json类似于
         * {
         * 	"code":"mgr_auth",
         * 	"pcode":"106",
         * 	"name":"用户鉴权",
         * 	"icon":"",
         * 	"url":"/mgr/auth",
         * 	"num":"1",
         * 	"ismenu":0
         * }
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
            //这里在前段界面上 菜单编号只要不要填写数据就行了 填一个英文菜单标识最好，如果填数字  恰好和下面选择的父级别菜单编号相同 那么会抛出下面的异常
            if (menuAddReq.getCode().equals(menuAddReq.getPcode())) {
                throw new ServiceException(BizExceptionEnum.MENU_PCODE_COINCIDENCE);
            }

            menu.setLevels(pLevels + 1);
            menu.setPcodes(pMenu.getPcodes() + "[" + pMenu.getCode() + "],");
        }

        menu.setStatus(MenuStatus.ENABLE.getCode());
        //对象转换  这里没有设置isopen是否有影响待定 status 也不是前段传过来
        menu.setCode(menuAddReq.getCode());
        menu.setName(menuAddReq.getName());
        menu.setIcon(menuAddReq.getIcon());
        menu.setUrl(menuAddReq.getUrl());
        menu.setNum(menuAddReq.getNum());
        menu.setIsmenu(menuAddReq.getIsmenu());

        menuMapper.insertMenus(menu);
        return baseResp;
    }

    @Override
    public BaseResp updateMenus(MenuUpdateReq menuUpdateReq, BaseResp baseResp) {

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
        return baseResp;
    }

    @Override
    @Transactional
    public BaseResp delMenus(MenuDelReq menuDelReq, BaseResp baseResp) {
        Menu menu = menuMapper.selectById(menuDelReq.getMenuId());
        //删除当前菜单
        delMenu(menu.getId());
        //删除所有子菜单
        String pcodes = "%[" + menu.getCode() + "]%";
        List<Menu> menus = menuMapper.selectSubMenusLike(pcodes);
        for (Menu temp : menus) {
            delMenu(temp.getId());
        }
        return baseResp;
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
    public BaseListResp getRoleMenuList(RoleMenuListReq roleMenuListReq, BaseListResp<ZTreeNode> baseListResp)
    {
        List<Long> menuIds = this.menuMapper.getMenuIdsByRoleId(roleMenuListReq.getRoleId());
        List<ZTreeNode> zTreeNodeList;
        if (CollectionUtil.isEmpty(menuIds)) {
            //在当前角色还未关联菜单的情况下需要把菜单按照层级显示出来 并且需要计算菜单的是否打开。只要有子级的菜单都是需要打开的。
            zTreeNodeList = this.menuMapper.menuTreeList();
        } else {
            //如果当前角色已经关联菜单的情况下，那么还需要计算这个菜单是否需要被checked 如果该菜单没有被选中 checked为false 否则为true
            zTreeNodeList = this.menuMapper.menuTreeListByMenuIds(menuIds);
        }
        baseListResp.setData(zTreeNodeList);
        return baseListResp;
    }
}
