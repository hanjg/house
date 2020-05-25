package com.babyjuan.house.manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: hjg
 * @Date: Create in 2018/12/10 22:03
 * @Description:
 */
@Configuration
public class ActionConfig {

    @Bean
    public Action crawlProcess() {
        return new Action();
    }

    @Bean
    public Action updateStatusProcess() {
        return new Action();
    }

    @Bean
    public Action shDealCrawlProcess() {
        return new Action();
    }

    @Bean
    public Action shDealUpdateStatusProcess() {
        return new Action();
    }
}
