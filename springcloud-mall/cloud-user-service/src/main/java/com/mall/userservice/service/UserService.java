package com.mall.userservice.service;

import com.mall.userservice.model.User;

import java.util.List;

/**
 * @author cheng
 */
public interface UserService {

    /**
     * 插入用户数据
     * @param user
     */
    void insert(User user);

    /**
     * 请求用户数据
     * @param id
     * @return
     */
    User getUser(Long id);

    /**
     * 更新用户数据
     * @param user
     */
    void update(User user);

    /**
     * 删除用户数据
     * @param id
     */
    void delete(Long id);

    /**
     * 通过用户姓名查询用户
     * @param username
     * @return
     */
    User getByUsername(String username);

    /**
     * 查询多个对象集合
     * @param ids
     * @return
     */
    List<User> listUsersByIds(List<Long> ids);
}
