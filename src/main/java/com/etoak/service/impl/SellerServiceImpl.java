package com.etoak.service.impl;

import com.etoak.dataobject.SellerInfo;
import com.etoak.repository.SellerInfoRespository;
import com.etoak.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/24
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRespository sellerInfoRespository;
    @Override
    public SellerInfo findSellerByOpenid(String openid) {
        SellerInfo sellerInfo = sellerInfoRespository.findByOpenid(openid);
        return sellerInfo;
    }
}
