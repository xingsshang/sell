package com.etoak.config;

import com.etoak.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/6/9
 */
@Configuration
public class MyServerConfig {
    /*注册三大组件*/
    @Bean
    public ServletRegistrationBean myServlet(){
        return new ServletRegistrationBean(new MyServlet(),"/myServlet");
    }
}
