package com.etoak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Executors;

@SpringBootApplication

@MapperScan("com.etoak.dataobject.mapper")
public class SellApplication {

	public static void main(String[] args) {
        int a =1;
        int b =1;
        System.out.println(a==b);
	}
}
