package com.example.order.util;

import java.util.UUID;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 20:34
 * @description：
 */
public class generateOrderId {

    /**
     * 生成唯一的订单ID
     * @return
     */
    public static synchronized String getOrderID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }
}
