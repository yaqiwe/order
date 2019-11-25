package com.example.order.repository;

import com.example.order.OrderApplicationTests;
import com.example.order.entity.orderMaster;
import com.example.order.enums.orderStatus;
import com.example.order.enums.payStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 14:59
 * @description：
 */
@Component
class orderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    orderMasterRepository orderMasterR;

    @Test
    void testAdd(){
        orderMaster orderM=new orderMaster();
        orderM.setOrderId("123456789");
        orderM.setBuyerName("dasdsadfsadf");
        orderM.setBuyerOpenid("yyyyyy");
        orderM.setBuyerPhone("223434546567");
        orderM.setBuyerAddress("地下停车场");
        orderM.setOrderId("1010101010101010");
        orderM.setOrderAmount(new BigDecimal(400));
        orderM.setOrderStatus(orderStatus.NEW_ORDER.getCode());
        orderM.setPayStatus(payStatus.WAIT.getCode());
        orderMaster save = orderMasterR.save(orderM);
        Assert.assertNotNull(save);
    }

}