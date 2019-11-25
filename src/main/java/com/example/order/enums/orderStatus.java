package com.example.order.enums;

import lombok.Getter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 15:32
 * @description：订单状态
 */
@Getter
public enum orderStatus {
    NEW_ORDER(0,"新订单"),
    END_ORDER(1,"已完结订单"),
    CANCEL_ORDER(2,"取消订单"),
    ;

    private String msg;

    private Integer code;

    orderStatus(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
