package com.babyjuan.house.service.crawler;

import com.babyjuan.house.base.BaseTest;
import com.babyjuan.house.dao.entity.CommunityExample;
import com.babyjuan.house.dao.entity.RentingHouseExample;
import com.babyjuan.house.dao.mapper.CommunityMapper;
import com.babyjuan.house.dao.mapper.RentingHouseMapper;
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
    @Autowired
    private RentingHouseMapper rentingHouseMapper;
    @Autowired
    private CommunityMapper communityMapper;

    @Test
    public void run() throws Exception {
        crawlerService.run();
    }

    @Test
    public void start() throws Exception {
        crawlerService.start(1);
        Thread.sleep(60 * 1000);
//        System.out.println(rentingHouseMapper.selectByExample(new RentingHouseExample()));
//        System.out.println(communityMapper.selectByExample(new CommunityExample()));
        Thread.sleep(60 * 1000);
//        System.out.println(rentingHouseMapper.selectByExample(new RentingHouseExample()));
//        System.out.println(communityMapper.selectByExample(new CommunityExample()));
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
    public void testUrl() throws InterruptedException {
        String url = "https://nj.lianjia.com/zufang/103102434083.html";
        crawlerService.test(url);
        Thread.sleep(10 * 1000);
    }
}