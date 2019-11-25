package com.example.order.exception;

import com.example.order.dto.Resoult;
import com.example.order.enums.exceptionEnum;
import com.example.order.util.ResoultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 16:53
 * @description：
 */
@ControllerAdvice
@ResponseBody
public class exceptionHandler {

    @ExceptionHandler(Exception.class)
    public Resoult errorHandler(Exception e) {
        /*自定义的错误类型*/
        if (e instanceof orderException) {
            orderException ce = (orderException) e;
            return ResoultUtil.error(ce.getCode(), ce.getMessage());
        }
        //其他异常，打印控制台
        e.printStackTrace();
        return ResoultUtil.error(exceptionEnum.UNKNOWN_ERROR);
    }
}