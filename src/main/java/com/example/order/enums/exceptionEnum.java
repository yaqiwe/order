package com.example.order.enums;

import lombok.Getter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 16:51
 * @description：
 */
@Getter
public enum exceptionEnum {
    UNKNOWN_ERROR(501,"未知错误"),

    PLACE_ORDER_ERROR(7001,"下单失败"),
    ;

    private String msg;

    private Integer code;

    exceptionEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
