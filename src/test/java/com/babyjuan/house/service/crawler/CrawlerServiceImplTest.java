package com.babyjuan.house.service.crawler;

import com.babyjuan.house.base.BaseTest;
import com.babyjuan.house.service.crawler.CrawlerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 18:29
 * @Description:
 */
public class CrawlerServiceImplTest extends BaseTest {

    @Autowired
    private CrawlerService crawlerService;

    @Test
    public void run() throws Exception {
        crawlerService.run();
    }

    @Test
    public void start() throws Exception {
        crawlerService.start();
        Thread.sleep(10 * 1000);
        crawlerService.stop();
        Thread.sleep(5 * 1000);
        crawlerService.start();
        Thread.sleep(10 * 1000);
        crawlerService.stop();
    }

    @Test
    public void stop() throws Exception {
        crawlerService.stop();
    }

    @Test
    public void runGivenTime() throws InterruptedException {
        crawlerService.run();
        Thread.sleep(30 * 1000);
        //没卵用，因为同步其他线程阻塞
        crawlerService.stop();
    }

    @Test
    public void testUrl() {
        String url = "https://nj.lianjia.com/zufang/103102437978.html";
        crawlerService.test(url);
    }
}