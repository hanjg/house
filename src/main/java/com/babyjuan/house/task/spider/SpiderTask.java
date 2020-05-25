package com.babyjuan.house.task.spider;

import com.babyjuan.house.service.CrawlerService;
import javax.annotation.Resource;
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

    @Resource(name = "shHouseDealCrawlerServiceImpl")
    private CrawlerService shHouseDealCrawlerService;

    @Scheduled(fixedDelay = 3 * 1000)
    public void shHouse() throws InterruptedException {
        secondHandCrawlerService.start(1);
    }
}
