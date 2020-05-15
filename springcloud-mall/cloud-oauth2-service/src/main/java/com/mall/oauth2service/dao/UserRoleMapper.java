package com.mall.oauth2service.dao;

import com.mall.oauth2service.model.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}