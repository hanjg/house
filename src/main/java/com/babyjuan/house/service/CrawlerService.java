package com.babyjuan.house.service;

import com.babyjuan.house.service.dto.BaseResponse;
import com.babyjuan.house.task.spider.SpiderState;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 16:04
 * @Description:
 */
public interface CrawlerService {

    /**
     * 异步执行爬虫，主线程终止，则爬虫终止
     */
    BaseResponse<String> start(int repeatTimes);

    SpiderState status();

    /**
     * 使用爬虫特定url
     */
    void test(String url, int repeatTimes);

}
