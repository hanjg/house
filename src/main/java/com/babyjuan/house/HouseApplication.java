package com.babyjuan.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class HouseApplication/* extends SpringBootServletInitializer */ {

    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class, args);
    }

    //   与在web.xml中配置负责初始化Spring应用上下文的监听器作用类似
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(HouseApplication.class);
//    }
}
