package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.modular.system.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

    List<Menu> selectMenus();

    Menu selectById(Long id);

    List<Menu> selectSubMenusLike(@Param("pcodes") String pcodes);

    List<ZTreeNode> menuTreeList();

    void insertMenus(Menu menu);

    void updateMenus(Menu menu);

    void delMenuById(@Param("id") Long id);

    List<Long> getMenuIdsByRoleId(@Param("roleId") Integer roleId);

    void deleteRelationByMenu(@Param("menuId") Long id);

    List<ZTreeNode> menuTreeListByMenuIds(List<Long> menuIds);
}
