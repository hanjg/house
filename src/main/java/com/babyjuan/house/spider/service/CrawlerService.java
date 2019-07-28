package com.babyjuan.house.spider.service;

import com.babyjuan.house.common.HouseResult;
import com.babyjuan.house.common.SpiderState;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 16:04
 * @Description:
 */
public interface CrawlerService {

    /**
     * 异步执行爬虫，主线程终止，则爬虫终止
     */
    HouseResult start(int repeatTimes);

    @Deprecated
    void stop();

    SpiderState status();

    /**
     * 使用爬虫特定url
     */
    void test(String url, int repeatTimes);

}
