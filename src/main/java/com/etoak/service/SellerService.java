package com.etoak.service;

import com.etoak.dataobject.SellerInfo;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/24
 */
public interface SellerService {
    SellerInfo findSellerByOpenid(String openid);
}
