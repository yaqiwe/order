package com.example.order.dto;

import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 15:49
 * @description：购物车DTO
 */
@Data
public class CartDto {

    private String productId;       //商品ID

    private Integer productQuantity;        //扣除的库存

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
