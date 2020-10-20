package com.babyjuan.house.rest;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.babyjuan.house.integration.HouseIntegrationApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 推荐直接实现接口，https://blog.csdn.net/lenkvin/article/details/79482205
 */
@SpringBootApplication
@Import(value = {
        HouseIntegrationApplication.class
})
@EnableDubbo
public class HouseRestApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(HouseRestApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
