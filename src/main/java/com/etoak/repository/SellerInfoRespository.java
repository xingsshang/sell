package com.etoak.repository;

import com.etoak.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/24
 */
public interface SellerInfoRespository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openid);
}
