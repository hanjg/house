package com.babyjuan.house.task.spider.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author: hjg
 * @Date: Create in 2018/12/12 15:23
 * @Description:
 */
@Component
@RefreshScope
public class CrawlerConst {

    @Value("${spider.threadnum}")
    private Integer threadNum;
    @Value("${spider.retryTimes}")
    private Integer retryTimes;
    @Value("${spider.sleepTime}")
    private Integer sleepTimes;

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    public Integer getSleepTimes() {
        return sleepTimes;
    }

    public void setSleepTimes(Integer sleepTimes) {
        this.sleepTimes = sleepTimes;
    }

    public Integer getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(Integer threadNum) {
        this.threadNum = threadNum;
    }
}
