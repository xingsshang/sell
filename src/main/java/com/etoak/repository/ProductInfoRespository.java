package com.etoak.repository;

import com.etoak.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
public interface ProductInfoRespository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
