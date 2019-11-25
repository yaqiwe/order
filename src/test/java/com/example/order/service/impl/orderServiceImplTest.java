package com.example.order.service.impl;

import com.example.order.OrderApplicationTests;
import com.example.order.dto.orderDto;
import com.example.order.entity.orderDetail;
import com.example.order.service.orderService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 17:01
 * @description：
 */
@Component
class orderServiceImplTest extends OrderApplicationTests {

    @Autowired
    orderService orderS;

    orderDto dto;

    public orderServiceImplTest() {
        dto=new orderDto();
        dto.setBuyerName("yyyy0");
        dto.setBuyerOpenid("12121212121212121");
        dto.setBuyerPhone("123456789");
        dto.setBuyerAddress("地下停车场");
    }

    @Test
    void createOrder() {
        List<orderDetail> deList=new ArrayList<>();
        orderDetail de=new orderDetail();
        de.setProductId("0001");
        de.setProductQuantity(20);
        deList.add(de);
        de=new orderDetail();
        de.setProductId("0003");
        de.setProductQuantity(20);
        deList.add(de);
        dto.setOrderDetailList(deList);
        orderDto order = orderS.createOrder(dto);
        Assert.assertNotNull(order.getOrderId());
    }
}