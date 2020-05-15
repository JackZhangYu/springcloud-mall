package com.mall.ssoserver.service;

import com.mall.ssoserver.domain.MyUser;
import com.mall.ssoserver.entity.SysPermission;
import com.mall.ssoserver.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cheng
 * @date 2020/5/8 9:53
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userService.getByUsername(username);
        if(null == sysUser){
            throw new UsernameNotFoundException(username + "用户没找到!");
        }
        List<SysPermission> permissionList = permissionService.findByUserId(sysUser.getId());
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(permissionList)) {
            for(SysPermission sysPermission : permissionList){
                authorityList.add(new SimpleGrantedAuthority(sysPermission.getCode()));
            }
        }
        MyUser myUser = new MyUser(sysUser.getUsername(),passwordEncoder.encode(sysUser.getPassword()),authorityList);
        return myUser;
    }
}
