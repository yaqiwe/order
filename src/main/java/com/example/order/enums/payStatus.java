package com.example.order.enums;

import lombok.Getter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 16:40
 * @description：
 */
@Getter
public enum payStatus {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private String msg;

    private Integer code;

    payStatus(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
