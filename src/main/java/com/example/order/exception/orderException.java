package com.example.order.exception;

import com.example.order.enums.exceptionEnum;
import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 16:50
 * @description：
 */
@Data
public class orderException extends RuntimeException {
    private Integer code;

    public orderException(exceptionEnum enums){
        super(enums.getMsg());
        code=enums.getCode();
    }

    public orderException() {
    }

    public orderException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }
}
