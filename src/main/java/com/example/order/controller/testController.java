package com.example.order.controller;

import com.example.order.client.productClient;
import com.example.order.dto.productInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 21:02
 * @description：
 */
@RestController
public class testController {

    @Autowired
    private productClient productC;

    @GetMapping("/testRestTemplate")
    public Object getTemplate(){
        List<String> list=new ArrayList<>();
        list.add("0001");
        list.add("0003");
        List<productInfo> productById = productC.getProductById(list);
        return productById;
    }
}
