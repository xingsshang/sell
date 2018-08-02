package com.etoak.service.impl;

import com.etoak.dataobject.ProductInfo;
import com.etoak.dto.CartDTO;
import com.etoak.enums.ProductStatusEnum;
import com.etoak.enums.ResultEnum;
import com.etoak.exception.SellException;
import com.etoak.repository.ProductInfoRespository;
import com.etoak.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRespository respository;
    @Override
    public ProductInfo findOne(String productId) {
        return respository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return respository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return respository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return respository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO :cartDTOList){
            ProductInfo productInfo = respository.findOne(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            respository.save(productInfo);
        };
    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo = respository.findOne(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            respository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = respository.findOne(productId);
        if(productInfo == null) throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        ProductInfo info = respository.save(productInfo);
        return info;
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = respository.findOne(productId);
        if(productInfo == null) throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        ProductInfo info = respository.save(productInfo);
        return info;
    }
}
