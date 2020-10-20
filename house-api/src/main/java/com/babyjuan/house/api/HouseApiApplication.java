package com.babyjuan.house.api;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.babyjuan.house.repository.HouseRepositoryApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.babyjuan.house.api.service")
@Import(value = {
        HouseRepositoryApplication.class
})
public class HouseApiApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(HouseApiApplication.class, args);
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
