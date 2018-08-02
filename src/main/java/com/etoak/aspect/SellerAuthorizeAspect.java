package com.etoak.aspect;

import com.etoak.constant.CookieConstant;
import com.etoak.constant.RedisConstant;
import com.etoak.exception.SellerAuthorizeException;
import com.etoak.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static com.etoak.constant.RedisConstant.TOKEN_PREFIX;

/**
 * @Description 校验是否登录
 * @Author 邢尚尚
 * @Date 2018/5/25
 */
@Aspect
@Slf4j
@Component
public class SellerAuthorizeAspect {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Pointcut("execution(public * com.etoak.controller.Seller*.*())" + "&& !execution(public * com.etoak.controller.SellerUserController.*(..))")
    public void verify(){

    }
    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // c查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie == null){
            log.info("【登录校验】Cookie中查不到");
            throw new SellerAuthorizeException();
        }
        /*去redis中查询*/
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if(StringUtils.isEmpty(tokenValue)){
            throw new SellerAuthorizeException();
        }

    }
}
