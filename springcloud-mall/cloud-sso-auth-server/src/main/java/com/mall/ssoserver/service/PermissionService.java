package com.mall.ssoserver.service;

import com.mall.ssoserver.entity.SysPermission;

import java.util.List;

/**
 * @author cheng
 * @date 2020/5/8 9:47
 */
public interface PermissionService {
    public List<SysPermission> findByUserId(Integer userId);

}
