package com.mall.ssoserver.repository;

import com.mall.ssoserver.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author cheng
 * @date 2020/5/8 9:26
 */
public interface SysUserRepository extends JpaSpecificationExecutor<SysUser>, JpaRepository<SysUser,Integer> {
    /**
     * 根据用户姓名查找是否存在用户
     * @param username
     * @return
     */
    SysUser findByUsername(String username);
}
