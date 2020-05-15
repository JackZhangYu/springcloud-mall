package com.mall.ssoserver.service;

import com.mall.ssoserver.entity.SysUser;

/**
 * @author cheng
 * @date 2020/5/8 9:39
 */
public interface UserService {
    SysUser getByUsername(String username);
}
