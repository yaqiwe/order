package com.example.order.service;

import com.example.order.dto.orderDto;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 20:14
 * @description：订单
 */
public interface orderService {

    /**
     * 创建订单
     * @param dto
     * @return
     */
    public orderDto createOrder(orderDto dto);
}
