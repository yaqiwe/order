package com.example.order.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 13:35
 * @description：
 */
@Data
public class productInfo {

    private String productId;   //商品Id

    private String productName;     //商品名称

    private BigDecimal productPrice;        //商品单价

    private Integer productStock;       //商品库存

    private String productDescription;      //描述

    private String productIcon;     //小图的Url

}
