package com.babyjuan.house.task.spider;

import com.babyjuan.house.repository.mysql.entity.CommunityExample;
import com.babyjuan.house.repository.mysql.entity.SecondHandHouseExample;
import com.babyjuan.house.repository.mysql.entity.ShHouseDealExample;
import com.babyjuan.house.repository.mysql.mapper.CommunityMapper;
import com.babyjuan.house.repository.mysql.mapper.RentingHouseMapper;
import com.babyjuan.house.repository.mysql.mapper.SecondHandHouseMapper;
import com.babyjuan.house.repository.mysql.mapper.ShHouseDealMapper;
import com.babyjuan.house.task.HouseTaskApplicationTests;
import com.babyjuan.house.task.spider.command.CrawlerCommand;
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
public class CrawlerCommandImplTest extends HouseTaskApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerCommandImplTest.class);

    @Autowired
    @Qualifier("secondHandCrawlerCommandImpl")
    private CrawlerCommand secondHandCrawlerCommand;
    @Resource(name = "shHouseDealCrawlerCommandImpl")
    private CrawlerCommand shHouseDealCrawlerCommand;

    @Autowired
    private RentingHouseMapper rentingHouseMapper;
    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private SecondHandHouseMapper secondHandHouseMapper;
    @Autowired
    private ShHouseDealMapper shHouseDealMapper;

    @Test
    public void testSh() throws InterruptedException {
        String url = "https://sh.lianjia.com/ershoufang/jiangqiao/pg3/";
        secondHandCrawlerCommand.test(url, 1);
        do {
            Thread.sleep(1000);
        }
        while (!secondHandCrawlerCommand.status().getStatus().equals(Status.Stopped));

        LOGGER.info("house from db: {}", secondHandHouseMapper.countByExample(new SecondHandHouseExample()));
        CommunityExample communityExample = new CommunityExample();
        communityExample.createCriteria().andCityEqualTo("上海");
        LOGGER.info("community from db: {}", communityMapper.countByExample(communityExample));
    }

    @Test
    public void testShdeal() throws InterruptedException {
        String url = "https://sh.lianjia.com/chengjiao/107101998462.html";
        shHouseDealCrawlerCommand.test(url, 1);
        do {
            Thread.sleep(1000);
        }
        while (!shHouseDealCrawlerCommand.status().getStatus().equals(Status.Stopped));
        LOGGER.info("house from db: {}", shHouseDealMapper.countByExample(new ShHouseDealExample()));
    }
}
