package com.babyjuan.house.spider;

import com.babyjuan.house.repository.entity.CommunityExample;
import com.babyjuan.house.repository.entity.SecondHandHouseExample;
import com.babyjuan.house.spider.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author anxi
 * @version 2019/7/24 0:49
 */
@Component
public class SpiderTask {

    @Autowired
    @Qualifier("secondHandCrawlerServiceImpl")
    private CrawlerService secondHandCrawlerService;

    @Scheduled(fixedDelay = 10 * 1000)
    public void testUrl2() throws InterruptedException {
        secondHandCrawlerService.start(1);
    }
}
