package com.etoak.repository;

import com.etoak.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/15
 */
public interface OrderDetailRespository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}
