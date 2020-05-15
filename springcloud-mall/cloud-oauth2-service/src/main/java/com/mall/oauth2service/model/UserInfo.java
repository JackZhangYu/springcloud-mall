package com.mall.oauth2service.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * cloud-user-info
 * @author 
 */
@Data
public class UserInfo implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String address;

    /**
     * 所属公司
     */
    private String company;

    private Date createDate;

    private String hobby;

    private static final long serialVersionUID = 1L;
}