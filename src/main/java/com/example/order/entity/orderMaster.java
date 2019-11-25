package com.example.order.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 14:38
 * @description：订单表
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class orderMaster {

    @Id
    private String orderId;     //订单Id

    private String buyerName;       //买家名字

    private String buyerPhone;      //买家电话

    private String buyerAddress;        //买家地址

    private String buyerOpenid;     //买家微信openid

    private BigDecimal orderAmount;     //订单总金额

    @Column(length = 3, columnDefinition = "TINYINT")
    private Integer orderStatus=0;        //订单状态,默认0，新下单

    @Column(length = 3, columnDefinition = "TINYINT")
    private Integer payStatus=0;      //支付状态，默认0未支付

    private Timestamp createTime;       //创建时间

    private Timestamp updateTime;       //更新时间
}
