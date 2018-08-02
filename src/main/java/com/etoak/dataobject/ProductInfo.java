package com.etoak.dataobject;

;
import com.etoak.enums.ProductStatusEnum;
import com.etoak.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
@Entity/*这是一个实例注解*/
@Data
@DynamicUpdate
public class ProductInfo {
    @Id/*这个注解应该是告诉hibernate 这个字段是主键吧*/
    private String productId;

    /*单价*/
    /*注意单价的类型 使用bigdecimal类型*/
    private BigDecimal productPrice;

    /*名称*/
    private String productName;

    /*库存*/
    private Integer productStock;

    /*商品描述*/
    private String productDescription;

    /*小图*/
    private String productIcon;

    /*类型编号*/
    private Integer categoryType;

    /*商品状态 0正常 1下架*/
    private Integer productStatus;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }
}
