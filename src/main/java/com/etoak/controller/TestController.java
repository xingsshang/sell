package com.etoak.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/7/11
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "sdfsd";
    }
}
