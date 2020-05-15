package com.mall.client.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author cheng
 * @date 2020/5/13 12:16
 */
@Data
public class EsUserInfo {

    private Integer id;

    @SerializedName(value = "username")
    private String username;

    @SerializedName(value = "email")
    private String email;

    @SerializedName(value = "earning")
    private BigDecimal earning;

    @SerializedName(value = "familypop")
    private Integer familyPop;

    @SerializedName(value = "education")
    private String education;

    @SerializedName(value = "address")
    private String address;

    @SerializedName(value = "expenditure")
    private BigDecimal expenditure;

    @SerializedName(value = "age")
    private Integer age;

    @SerializedName(value = "persondetail")
    private String personDetail;

    @SerializedName(value = "registertime")
    private String registerTime;
}
