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
package com.jialong.powersite.modular.system.service.impl;

import cn.hutool.core.convert.Convert;
import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.modular.system.mapper.RelationMapper;
import com.jialong.powersite.modular.system.mapper.RoleMapper;
import com.jialong.powersite.modular.system.mapper.UserMapper;
import com.jialong.powersite.modular.system.model.Relation;
import com.jialong.powersite.modular.system.model.Role;
import com.jialong.powersite.modular.system.model.User;
import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色服务
 *
 * @author fengshuonan
 * @Date 2018/10/15 下午11:40
 */
@Service
public class RoleServiceImpl{

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RelationMapper relationMapper;

    public RoleListResp queryRoleList(RoleListReq roleListReq, RoleListResp roleListResp)
    {
        List<Role> roles = roleMapper.selectRoles();
        roleListResp.setData(roles);
        return roleListResp;
    }




    @Transactional
    public RoleDelResp delRoleById(RoleDelReq roleDelReq, RoleDelResp roleDelResp) {
        //删除角色
        this.roleMapper.deleteRoleById(roleDelReq.getId());

        // 删除该角色所有的权限
        this.roleMapper.deleteRelationByRoleId(roleDelReq.getId());

        return roleDelResp;
    }


    public RoleAddResp AddRole(RoleAddReq roleAddReq, RoleAddResp roleAddResp) {
        Role role = new Role();
        role.setName(roleAddReq.getName());
        role.setNum(roleAddReq.getNum());
        role.setPid(roleAddReq.getPid());
        role.setDeptid(roleAddReq.getDeptid());
        role.setTips(roleAddReq.getTips());
        role.setVersion(roleAddReq.getVersion());
        this.roleMapper.addRole(role);
        return roleAddResp;
    }

    public RoleUpdateResp updateRole(RoleUpdateReq roleUpdateReq, RoleUpdateResp roleUpdateResp) {
        Role role = new Role();
        role.setId(roleUpdateReq.getId());
        role.setName(roleUpdateReq.getName());
        role.setNum(roleUpdateReq.getNum());
        role.setPid(roleUpdateReq.getPid());
        role.setDeptid(roleUpdateReq.getDeptid());
        role.setTips(roleUpdateReq.getTips());
        role.setVersion(roleUpdateReq.getVersion());
        this.roleMapper.updateRole(role);
        return roleUpdateResp;
    }

    public UserRoleListResp roleTreeListByUserId(UserRoleListReq userRoleReq, UserRoleListResp userRoleResp) {
        User theUser = this.userMapper.queryUserById(userRoleReq.getId());
        String roleid = theUser.getRoleid();
        List<ZTreeNode> zTreeNodes;
        if (StringUtils.isEmpty(roleid)) {
            zTreeNodes = this.roleTreeList();
        } else {
            String[] strArray = roleid.split(",");
            zTreeNodes = this.roleTreeListByRoleId(strArray);
        }
        userRoleResp.setData(zTreeNodes);
        return userRoleResp;
    }

    public List<ZTreeNode> roleTreeList() {
        return this.roleMapper.roleTreeList();
    }

    public List<ZTreeNode> roleTreeListByRoleId(String[] roleId) {
        return this.roleMapper.roleTreeListByRoleId(roleId);
    }



    @Transactional
    public RoleMenuSetResp setAuthority(RoleMenuSetReq roleMenuSetReq, RoleMenuSetResp roleMenuSetResp) {

        // 删除该角色所有的权限
        this.roleMapper.deleteRelationByRoleId(roleMenuSetReq.getRoleId());

        // 添加新的权限
        for (Long id : Convert.toLongArray(roleMenuSetReq.getMenuIds().split(","))) {
            Relation relation = new Relation();
            relation.setRoleid(roleMenuSetReq.getRoleId());
            relation.setMenuid(id);
            this.relationMapper.insertRelation(relation);
        }
        return roleMenuSetResp;
    }

}
