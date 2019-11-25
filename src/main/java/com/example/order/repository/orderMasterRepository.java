package com.example.order.repository;

import com.example.order.entity.orderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 14:58
 * @description：订单表
 */
public interface orderMasterRepository extends JpaRepository<orderMaster,String> {
}
