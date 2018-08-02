package com.etoak.dataobject;

import com.etoak.enums.OrderStatusEnum;
import com.etoak.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/14
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    /*订单id*/
    @Id
    private String orderId;

    /*买家名称*/
    private String buyerName;

    /*买家手机号*/
    private  String buyerPhone;

    /*买家地址*/
    private  String buyerAddress;

    /*买家openid*/
    private String buyerOpenid;

    /*订单总金额*/
    private BigDecimal orderAmount;

    /*订单状态*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /*支付状态*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    private Date createTime;
    private Date updateTime;

}
