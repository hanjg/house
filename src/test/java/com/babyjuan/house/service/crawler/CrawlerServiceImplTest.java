package com.babyjuan.house.service.crawler;

import com.babyjuan.house.HouseApplicationTests;
import com.babyjuan.house.dao.CommunityMapper;
import com.babyjuan.house.dao.RentingHouseMapper;
import com.babyjuan.house.dao.entity.CommunityExample;
import com.babyjuan.house.dao.entity.RentingHouseExample;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Spider.Status;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 18:29
 * @Description:
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public class CrawlerServiceImplTest extends HouseApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerServiceImplTest.class);

    @Autowired
    private CrawlerService crawlerService;
    @Autowired
    private RentingHouseMapper rentingHouseMapper;
    @Autowired
    private CommunityMapper communityMapper;

    @Test
    public void start() throws Exception {
        crawlerService.start(2);
        do {
            Thread.sleep(1000);
        }
        while (!crawlerService.status().getStatus().equals(Status.Stopped));

        LOGGER.info("house from db: {}", rentingHouseMapper.countByExample(new RentingHouseExample()));
        LOGGER.info("community from db: {}", communityMapper.countByExample(new CommunityExample()));
    }

    @Test
    public void testUrl() throws InterruptedException {
        String url = "https://nj.lianjia.com/zufang/103102434083.html";
        crawlerService.test(url, 2);
        do {
            Thread.sleep(1000);
        }
        while (!crawlerService.status().getStatus().equals(Status.Stopped));

        LOGGER.info("house from db: {}", rentingHouseMapper.countByExample(new RentingHouseExample()));
        LOGGER.info("community from db: {}", communityMapper.countByExample(new CommunityExample()));
    }
}