package com.example.order.repository;

import com.example.order.entity.orderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 14:56
 * @description：商品详情表
 */
@Repository
public interface orderDetailRepository extends JpaRepository<orderDetail,String> {

}
