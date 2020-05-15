package com.mall.ssoserver.repository;

import com.mall.ssoserver.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author cheng
 * @date 2020/5/8 9:29
 */
public interface SysPermissionRepository extends JpaSpecificationExecutor<SysPermission>, JpaRepository<SysPermission,Integer> {

    @Query(value = "SELECT * FROM sys_permission WHERE id IN (:ids)",nativeQuery = true)
    List<SysPermission> findByIds(@Param("ids") List<Integer> ids);
}
