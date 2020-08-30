package com.babyjuan.house.spider;

import com.babyjuan.house.HouseApplicationTests;
import com.babyjuan.house.repository.mysql.mapper.CommunityMapper;
import com.babyjuan.house.repository.mysql.mapper.RentingHouseMapper;
import com.babyjuan.house.repository.mysql.mapper.SecondHandHouseMapper;
import com.babyjuan.house.repository.mysql.mapper.ShHouseDealMapper;
import com.babyjuan.house.repository.mysql.entity.CommunityExample;
import com.babyjuan.house.repository.mysql.entity.RentingHouseExample;
import com.babyjuan.house.repository.mysql.entity.SecondHandHouseExample;
import com.babyjuan.house.repository.mysql.entity.ShHouseDealExample;
import com.babyjuan.house.service.CrawlerService;
import javax.annotation.Resource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("crawlerServiceImpl")
    private CrawlerService crawlerService;
    @Autowired
    @Qualifier("secondHandCrawlerServiceImpl")
    private CrawlerService secondHandCrawlerService;
    @Resource(name = "shHouseDealCrawlerServiceImpl")
    private CrawlerService shHouseDealCrawlerService;

    @Autowired
    private RentingHouseMapper rentingHouseMapper;
    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private SecondHandHouseMapper secondHandHouseMapper;
    @Autowired
    private ShHouseDealMapper shHouseDealMapper;

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
    public void testRent() throws InterruptedException {
        String url = "https://nj.lianjia.com/zufang/103102434083.html";
        crawlerService.test(url, 2);
        do {
            Thread.sleep(1000);
        }
        while (!crawlerService.status().getStatus().equals(Status.Stopped));

        LOGGER.info("house from db: {}", rentingHouseMapper.countByExample(new RentingHouseExample()));
        LOGGER.info("community from db: {}", communityMapper.countByExample(new CommunityExample()));
    }

    @Test
    public void testSh() throws InterruptedException {
        String url = "https://sh.lianjia.com/ershoufang/jiangqiao/pg3/";
        secondHandCrawlerService.test(url, 1);
        do {
            Thread.sleep(1000);
        }
        while (!secondHandCrawlerService.status().getStatus().equals(Status.Stopped));

        LOGGER.info("house from db: {}", secondHandHouseMapper.countByExample(new SecondHandHouseExample()));
        CommunityExample communityExample = new CommunityExample();
        communityExample.createCriteria().andCityEqualTo("上海");
        LOGGER.info("community from db: {}", communityMapper.countByExample(communityExample));
    }

    @Test
    public void testShdeal() throws InterruptedException {
        String url = "https://sh.lianjia.com/chengjiao/107101998462.html";
        shHouseDealCrawlerService.test(url, 1);
        do {
            Thread.sleep(1000);
        }
        while (!shHouseDealCrawlerService.status().getStatus().equals(Status.Stopped));
        LOGGER.info("house from db: {}", shHouseDealMapper.countByExample(new ShHouseDealExample()));
    }
}
