package com.example.order.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 14:50
 * @description：订单详情表
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class orderDetail {

    @Id
    private String detailId;

    private String orderId;     //订单ID

    private String productId;       //商品id

    private String productName;     //商品名称

    private BigDecimal productPrice;        //商品价格

    private Integer productQuantity;        //商品数量

    private String productIcon;     //商品小图

    private Timestamp createTime;       //创建时间

    private Timestamp updateTime;       //更新时间
}
