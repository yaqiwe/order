package com.example.order.dto;

import com.example.order.entity.orderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 20:17
 * @description：订单表和订单详情的关联对象
 */
@Data
public class orderDto {

    private String orderId;     //订单Id

    private String buyerName;       //买家名字

    private String buyerPhone;      //买家电话

    private String buyerAddress;        //买家地址

    private String buyerOpenid;     //买家微信openid

    private BigDecimal orderAmount;     //订单总金额

    private Integer orderStatus;        //订单状态,默认0，新下单

    private Integer payStatus;      //支付状态，默认0未支付

    private List<orderDetail> orderDetailList;      //订单详情列表
}
