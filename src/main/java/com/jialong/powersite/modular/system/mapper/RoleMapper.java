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
package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.core.common.node.ZTreeNode;
import com.jialong.powersite.modular.system.model.Role;
import com.jialong.powersite.modular.system.model.response.data.RoleListRespData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    List<RoleListRespData> selectRoles();

    int deleteRoleById(@Param("roleId") Integer roleId);

    int deleteRelationByRoleId(@Param("roleId") Integer roleId);

    int addRole(Role role);

    int updateRole(Role role);

    List<ZTreeNode> roleTreeList();

    List<ZTreeNode> roleTreeListByRoleId(String[] roleId);

}