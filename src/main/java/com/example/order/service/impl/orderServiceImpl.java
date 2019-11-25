package com.example.order.service.impl;

import com.example.order.client.productClient;
import com.example.order.dto.CartDto;
import com.example.order.dto.Resoult;
import com.example.order.dto.orderDto;
import com.example.order.dto.productInfo;
import com.example.order.entity.orderDetail;
import com.example.order.entity.orderMaster;
import com.example.order.enums.exceptionEnum;
import com.example.order.enums.orderStatus;
import com.example.order.enums.payStatus;
import com.example.order.exception.orderException;
import com.example.order.repository.orderDetailRepository;
import com.example.order.repository.orderMasterRepository;
import com.example.order.service.orderService;
import com.example.order.util.generateOrderId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 20:21
 * @description：
 */
@Service
public class orderServiceImpl implements orderService {

    @Autowired
    orderDetailRepository orderDetailR;

    @Autowired
    orderMasterRepository orderMasterR;

    @Autowired
    private productClient productC;

    @Override
    @Transactional
    public orderDto createOrder(orderDto dto) {
        //查询商品信息
        List<String> productIdList = dto.getOrderDetailList()
                .stream().map(orderDetail::getProductId)
                .collect(Collectors.toList());
        List<productInfo> productList = productC.getProductById(productIdList);

        //生成订单Id
        String orderID = generateOrderId.getOrderID();

        //计算总价,并把商品信息复制到orderDto里
        BigDecimal OrderAmount = new BigDecimal(0);
        for (orderDetail ord : dto.getOrderDetailList()) {
            for (productInfo pro : productList) {
                if (ord.getProductId().equals(pro.getProductId())) {
                    //计算价格并加到总价里
                    OrderAmount=pro.getProductPrice()
                            .multiply(new BigDecimal(ord.getProductQuantity()))
                            .add(OrderAmount);
                    BeanUtils.copyProperties(pro, ord);
                    ord.setOrderId(orderID);
                    //生成订单详情的ID
                    ord.setDetailId(generateOrderId.getOrderID());
                    //订单详情入库
                    orderDetailR.save(ord);
                }
            }
        }

        //订单入库
        orderMaster master = new orderMaster();
        dto.setOrderId(orderID);
        BeanUtils.copyProperties(dto, master);
        master.setOrderAmount(OrderAmount);
        master.setPayStatus(payStatus.WAIT.getCode());
        master.setOrderStatus(orderStatus.NEW_ORDER.getCode());
        orderMasterR.save(master);

        //扣库存
        List<CartDto> caList = dto.getOrderDetailList().stream()
                .map(e -> new CartDto(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        Resoult decreaseStockResoult = productC.decreaseStock(caList);
        if (!decreaseStockResoult.getCode().equals(200)) {
            //扣除库存失败
            throw new orderException(exceptionEnum.PLACE_ORDER_ERROR.getCode(),decreaseStockResoult.getMsg());
        }
        return dto;
    }
}
