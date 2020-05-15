package com.mall.ssoserver.service.impl;

import com.mall.ssoserver.entity.SysPermission;
import com.mall.ssoserver.entity.SysRolePermission;
import com.mall.ssoserver.entity.SysUserRole;
import com.mall.ssoserver.repository.SysPermissionRepository;
import com.mall.ssoserver.repository.SysRolePermissionRepository;
import com.mall.ssoserver.repository.SysUserRoleRepository;
import com.mall.ssoserver.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cheng
 * @date 2020/5/8 9:57
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;
    @Autowired
    private SysRolePermissionRepository sysRolePermissionRepository;
    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Override
    public List<SysPermission> findByUserId(Integer userId) {
        List<SysUserRole> sysUserRoleList = sysUserRoleRepository.findByUserId(userId);
        if (CollectionUtils.isEmpty(sysUserRoleList)) {
            return null;
        }
        List<Integer> roleIdList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        List<SysRolePermission> rolePermissionList = sysRolePermissionRepository.findByRoleIds(roleIdList);
        if (CollectionUtils.isEmpty(rolePermissionList)) {
            return null;
        }
        List<Integer> permissionIdList = rolePermissionList.stream().map(SysRolePermission::getPermissionId).distinct().collect(Collectors.toList());
        List<SysPermission> permissionList = sysPermissionRepository.findByIds(permissionIdList);
        if (CollectionUtils.isEmpty(permissionList)) {
            return null;
        }
        return permissionList;
    }
}
