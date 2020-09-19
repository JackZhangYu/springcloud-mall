package com.mall.userservice.model;

import java.io.Serializable;
import lombok.Data;

/**
 * t_stock
 * @author 
 */
@Data
public class StockModel implements Serializable {
    private Long id;

    private String name;

    private Integer stock;

    private static final long serialVersionUID = 1L;
}