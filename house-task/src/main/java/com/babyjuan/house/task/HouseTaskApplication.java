package com.babyjuan.house.task;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.babyjuan.house.repository.HouseRepositoryApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableDubbo(scanBasePackages = "com.babyjuan.house.task")
@Import(value = {
        HouseRepositoryApplication.class
})
public class HouseTaskApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(HouseTaskApplication.class, args);
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
