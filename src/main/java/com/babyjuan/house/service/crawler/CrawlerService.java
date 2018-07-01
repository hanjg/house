package com.babyjuan.house.service.crawler;

import com.babyjuan.house.common.HouseResult;
import com.babyjuan.house.service.crawler.model.SpiderState;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 16:04
 * @Description:
 */
public interface CrawlerService {

    /**
     * 同步执行爬虫
     */
    HouseResult run();

    /**
     * 异步执行爬虫，主线程终止，则爬虫终止
     */
    HouseResult start(int repeatTimes);

    @Deprecated
    void stop();

    SpiderState status();

    /**
     * 使用爬虫抓取一个url测试
     */
    void test(String url);

}
