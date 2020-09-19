package com.mall.userservice.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 再使用redis得时候，如果对象不实现Serializable得接口类实现序列化，程序运行会出现无法进行序列化得报错
 * @author cheng
 * @date 2020/7/11 11:17
 */
@Data
public class BrandModel implements Serializable {
    private Long id;
    private String name;
    private String firstLetter;
    private Integer sort;
    private Integer factoryStatus;
    private Integer showStatus;
    private Integer productCount;
    private Integer productCommentCount;
    private String logo;
    private String bigPic;
    private String brandStory;
}
