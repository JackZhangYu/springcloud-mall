package com.mall.ssoserver.vo;

import com.mall.ssoserver.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author cheng
 * @date 2020/5/8 10:16
 */
@Data
public class SysUserVO extends SysUser {

    /**
     * 用户权限列表
     */
    private List<String> authorityList;

}
