package com.etoak.controller;

import com.etoak.dto.OrderDTO;
import com.etoak.enums.ResultEnum;
import com.etoak.exception.SellException;
import com.etoak.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.Map;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/22
 */
@Controller
@Slf4j
@RequestMapping("seller/order")
public class SellerController {
    @Autowired
    private OrderService  orderService;
    /*由于是模板渲染 所以返回的是 modelandview*/
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1")Integer page,@RequestParam(value = "size",defaultValue = "10")Integer size,Map<String,Object> map){
        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage= orderService.findList(pageRequest);
        map.put("currentPage",page);
        map.put("orderDTOPage",orderDTOPage);
        return  new ModelAndView("order/list",map);

    }
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId")String orderId,Map<String,Object> map){
        OrderDTO orderDTO = null;
        try {
            orderDTO  = orderService.findOne(orderId);
            OrderDTO orderDTO1 = orderService.cancel(orderDTO);
        }catch (SellException e){
            log.error("【卖家取消订单】查询不到订单");
            map.put("msg", ResultEnum.ORDER_NOT_EXIST.getMsg());
            map.put("url","/sell/seller/order/list");
            return  new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.SUCCESS.getMsg());
        map.put("url","/sell/seller/order/list");
        return  new ModelAndView("common/success",map);
    }
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId")String orderId,Map<String,Object> map){
        OrderDTO orderDTO =null;
        try {
            orderDTO= orderService.findOne(orderId);

        }catch (SellException e){
            log.error("【卖家端查询订单详情】发生异常 e={}",e);
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");
            return  new ModelAndView("common/error",map);
        }
        map.put("orderDTO",orderDTO);
        return  new ModelAndView("order/detail",map);

    }
    @GetMapping("/finished")
    public ModelAndView finished(@RequestParam("orderId")String orderId,Map<String,Object> map){

        OrderDTO orderDTO =new OrderDTO();
        try {
        orderDTO  = orderService.findOne(orderId);
        orderService.finish(orderDTO);
        }catch (SellException e){
            log.error("【卖家端完结订单】发生异常 e={}",e);
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");
            return  new ModelAndView("common/error",map);
        }
        map.put("msg","订单完结成功");
        map.put("url","/sell/seller/order/list");
        return  new ModelAndView("common/success");
    }
}

