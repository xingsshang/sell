package com.etoak.controller;

import com.etoak.VO.ResultVO;
import com.etoak.converter.OrderForm2OrderDTO;
import com.etoak.dto.OrderDTO;
import com.etoak.enums.ResultEnum;
import com.etoak.exception.SellException;
import com.etoak.form.OrderForm;
import com.etoak.service.BuyerService;
import com.etoak.service.OrderService;
import com.etoak.service.RedisLock;
import com.etoak.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/17
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
           log.error("【创建订单】参数不正确，orderForm={}",orderForm);
           throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                   bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTO.converter(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO orderResult = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderDTO.getOrderId());
        return ResultVOUtil.success(map);

    }
    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(HttpServletRequest request,String openid, @RequestParam(value="page",defaultValue = "0") Integer page, @RequestParam(value = "size",defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【订单查询】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page,size);
        Page<OrderDTO> orderDTOList = orderService.findList(openid, pageRequest);
        return ResultVOUtil.success(orderDTOList.getContent());
    }
    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO>  detail(String openId,String orderId){
        // TODO 不安全的做法
        OrderDTO orderDTO = buyerService.findOrderOne(openId,orderId);

        return ResultVOUtil.success(orderDTO);
    }
    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(String openId,String orderId){
        // TODO 不安全的做法
        buyerService.cancelOrder(openId, orderId);
        return ResultVOUtil.success();
    }
}
