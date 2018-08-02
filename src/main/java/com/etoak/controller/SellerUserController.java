package com.etoak.controller;

import com.etoak.constant.CookieConstant;
import com.etoak.constant.RedisConstant;
import com.etoak.dataobject.SellerInfo;
import com.etoak.enums.ResultEnum;
import com.etoak.service.SellerService;
import com.etoak.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/24
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "openid")String openid,
                              Map<String,Object> map,
                              HttpServletResponse response){
        /*openid 去和数据库里面的   数据匹配*/
        SellerInfo sellerInfo= sellerService.findSellerByOpenid(openid);
        if(sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_FAIL);
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        /*设置token 放入 redis*/
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire, TimeUnit.SECONDS);
        /*设置token至cookie*/
        CookieUtil.set(response,"token",token,expire);
        return new ModelAndView("redirect:/seller/order/list");
    }
    @RequestMapping("logout")
    public ModelAndView logout(HttpServletResponse response,
                       HttpServletRequest request,
                       Map<String,Object> map){
        /*从cookie 中查询*/
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie!=null){
            /*从redis中清除*/
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            /*清除cookie*/
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
        map.put("msg","登出成功");
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
}
