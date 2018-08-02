package com.etoak.service;

import com.etoak.dataobject.ProductInfo;
import com.etoak.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
public interface ProductService {
    ProductInfo findOne(String productId);
    /*返回所有上架商品*/
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);
    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);
    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);
    /*上架*/
    ProductInfo onSale(String productId);
    /*下架*/
    ProductInfo offSale(String productId);
}
