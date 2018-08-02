package com.etoak.dto;

import com.etoak.dataobject.OrderDetail;
import com.etoak.enums.OrderStatusEnum;
import com.etoak.enums.PayStatusEnum;
import com.etoak.utils.EnumUtil;
import com.etoak.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/15
 */
@Data
/*@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)*/

/*这个注解是 不显示 是空的字段*/
/*@JsonInclude(JsonInclude.Include.NON_NULL)*/
public class OrderDTO {
    private String orderId;

    /*买家名称*/
    private String buyerName;

    /**买家手机号*/
    private  String buyerPhone;

    /*买家地址*/
    private  String buyerAddress;

    /*买家openid*/
    private String buyerOpenid;

    /*订单总金额*/
    private BigDecimal orderAmount;

    /*订单状态*/
    private Integer orderStatus ;

    /*支付状态*/
    private Integer payStatus;
    @JsonSerialize(using = Date2LongSerializer.class )
    private Date createTime;
    @JsonSerialize(using = Date2LongSerializer.class )
    private Date updateTime;
    private List<OrderDetail> orderDetailList =new ArrayList<>();
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
