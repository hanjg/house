package com.babyjuan.house.task.spider.command;

import com.babyjuan.house.task.spider.webmagic.SpiderState;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 16:04
 * @Description:
 */
public interface CrawlerCommand {

    /**
     * 异步执行爬虫，主线程终止，则爬虫终止
     */
    String start(int repeatTimes);

    String stop();

    SpiderState status();

    /**
     * 使用爬虫特定url
     */
    void test(String url, int repeatTimes);

}
