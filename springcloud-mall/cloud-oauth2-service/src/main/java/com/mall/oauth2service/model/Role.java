package com.mall.oauth2service.model;

import java.io.Serializable;
import lombok.Data;

/**
 * role
 * @author cheng
 */
@Data
public class Role implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}