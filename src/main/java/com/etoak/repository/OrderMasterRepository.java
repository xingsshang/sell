package com.etoak.repository;

import com.etoak.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/15
 * 他的dao层是一个接口 不是一个类
 */

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
