package com.jialong.powersite.modular.system.service.impl;

import cn.hutool.core.convert.Convert;
import com.jialong.powersite.core.common.constant.Constant;
import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.core.exception.BizExceptionEnum;
import com.jialong.powersite.core.exception.ServiceException;
import com.jialong.powersite.core.utils.ToolUtil;
import com.jialong.powersite.modular.system.mapper.RelationMapper;
import com.jialong.powersite.modular.system.mapper.RoleMapper;
import com.jialong.powersite.modular.system.mapper.UserMapper;
import com.jialong.powersite.modular.system.model.Relation;
import com.jialong.powersite.modular.system.model.Role;
import com.jialong.powersite.modular.system.model.User;
import com.jialong.powersite.modular.system.model.request.*;
import com.jialong.powersite.modular.system.model.response.*;
import com.jialong.powersite.modular.system.service.IRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleServiceImpl implements IRoleService {

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
        if (ToolUtil.isEmpty(roleDelReq.getId()))
        {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        //不能删除超级管理员角色
        if (roleDelReq.getId().equals(Constant.ADMIN_ROLE_ID)) {
            throw new ServiceException(BizExceptionEnum.CANT_DELETE_ADMIN);
        }

        //删除角色
        this.roleMapper.deleteRoleById(roleDelReq.getId());

        // 删除该角色所有的权限
        this.roleMapper.deleteRelationByRoleId(roleDelReq.getId());

        return roleDelResp;
    }

    public RoleAddResp addRole(RoleAddReq roleAddReq, RoleAddResp roleAddResp) {
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
        if (null == theUser)
        {
            userRoleResp.setErrorCode(String.valueOf(BizExceptionEnum.USER_NOT_EXISTED.getCode()));
            userRoleResp.setErrorMsg(BizExceptionEnum.USER_NOT_EXISTED.getMessage());
            return userRoleResp;
        }
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
        // 添加新的权限 也就是新增sys_relation里面的关联关系
        for (Long id : Convert.toLongArray(roleMenuSetReq.getMenuIds().split(","))) {
            Relation relation = new Relation();
            relation.setRoleid(roleMenuSetReq.getRoleId());
            relation.setMenuid(id);
            this.relationMapper.insertRelation(relation);
        }
        return roleMenuSetResp;
    }
}
