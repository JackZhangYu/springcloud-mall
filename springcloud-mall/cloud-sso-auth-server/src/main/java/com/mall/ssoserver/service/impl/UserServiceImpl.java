package com.mall.ssoserver.service.impl;

import com.mall.ssoserver.entity.SysUser;
import com.mall.ssoserver.repository.SysUserRepository;
import com.mall.ssoserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cheng
 * @date 2020/5/8 9:56
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserRepository sysUserRepository;
    @Override
    public SysUser getByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }
}
