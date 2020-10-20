package com.babyjuan.house.task.spider;

import com.babyjuan.house.task.spider.command.CrawlerCommand;
import com.babyjuan.house.task.spider.config.CrawlerSwitchConfig;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author anxi
 * @version 2019/7/24 0:49
 */
@Component
public class SpiderTask {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "secondHandCrawlerCommandImpl")
    private CrawlerCommand secondHandCrawlerCommand;

    @Resource(name = "shHouseDealCrawlerCommandImpl")
    private CrawlerCommand shHouseDealCrawlerCommand;

    @Autowired
    private CrawlerSwitchConfig crawlerSwitchConfig;

    @Scheduled(fixedDelay = 3 * 1000)
    public void shHouse() {
        if (!crawlerSwitchConfig.on()) {
            return;
        }
        secondHandCrawlerCommand.start(1);
    }
}
