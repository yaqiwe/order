package com.example.order.client;

import com.example.order.dto.CartDto;
import com.example.order.dto.Resoult;
import com.example.order.dto.productInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 12:27
 * @description：调用服务端的商品服务
 */
@FeignClient(name = "produck")
@RequestMapping("/product")
public interface productClient {

    @GetMapping("/getProductList")
    public String productList();


    /**
     * 根据商品ID查询商品信息
     * @param productIdList
     * @return
     */
    @PostMapping("/getProductById")
    List<productInfo> getProductById(List<String> productIdList);

    /**
     * 扣除商品列表中的库存
     * @param productStock
     */
    @PostMapping("/decreaseStock")
    Resoult decreaseStock(List<CartDto> productStock);
}
