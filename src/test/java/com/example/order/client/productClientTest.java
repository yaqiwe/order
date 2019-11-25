package com.example.order.client;

import com.example.order.OrderApplicationTests;
import com.example.order.dto.CartDto;
import com.example.order.dto.Resoult;
import com.example.order.dto.productInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 15:50
 * @description：
 */
@Component
@Slf4j
class productClientTest extends OrderApplicationTests {

    @Autowired
    productClient productC;

    @Test
    void getProductById() {
        List<String> productList=new ArrayList<>();
        productList.add("0001");
        productList.add("0002");
        List<productInfo> productById = productC.getProductById(productList);
        log.info("getProductById List: {}",productById);
        Assert.assertTrue(productById.size()>0);
    }

    @Test
    void decreaseStock() {
        List<CartDto> list=new ArrayList<>();
        list.add(new CartDto("0001",10));
        list.add(new CartDto("0003",20));
        Resoult resoult = productC.decreaseStock(list);
        Assert.assertTrue(resoult.getCode().equals(200));
    }
}