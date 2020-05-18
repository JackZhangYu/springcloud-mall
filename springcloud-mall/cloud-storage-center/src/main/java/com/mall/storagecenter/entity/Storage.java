package com.mall.storagecenter.entity;

import lombok.Data;

/**
 * @author cheng
 * @date 2020/5/17 19:30
 */
@Data
public class Storage {
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
