package com.etoak.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.PrintConversionEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/25
 */
public class CookieUtil {
    public static void set(HttpServletResponse response,String name,String value,int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    public static Cookie get(HttpServletRequest request,String name){
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if(cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }
        return null;
    }
    private static Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Map<String,Cookie> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie k: cookies){
                map.put(k.getName(),k);
            }
        }
        return map;
    }
}
