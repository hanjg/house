package com.babyjuan.house.task.spider.config;

import com.babyjuan.house.common.config.BaseNacoConfig;
import com.babyjuan.house.task.spider.command.CrawlerCommand;
import javax.annotation.Resource;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.context.annotation.Configuration;

/**
 * @author anxi
 * @version 2020/9/13 10:49
 */
@Configuration
public class CrawlerSwitchConfig extends BaseNacoConfig {

    private volatile boolean on;

    @Resource(name = "secondHandCrawlerCommandImpl")
    private CrawlerCommand crawlerCommand;

    @Override
    public String dataId() {
        return "house-task-spider-switch";
    }

    @Override
    public void initContent(String content) {
        on = BooleanUtils.toBoolean(content);
    }

    @Override
    public void changeContent(String content) {
        boolean newStatus = BooleanUtils.toBoolean(content);
        if (newStatus && !on) {
            crawlerCommand.start(1);
        } else if (!newStatus && on) {
            crawlerCommand.stop();
        } else {
            logger.info("crawler status unchange, {} -> {}", on, newStatus);
        }
        on = newStatus;
    }

    public boolean on() {
        return on;
    }
}
