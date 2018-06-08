package com.babyjuan.house.service.crawler;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 16:04
 * @Description:
 */
public interface CrawlerService {

    void run();

    void stop();

    /**
     * 使用爬虫抓取一个url测试
     * @param url
     */
    void test(String url);

}
