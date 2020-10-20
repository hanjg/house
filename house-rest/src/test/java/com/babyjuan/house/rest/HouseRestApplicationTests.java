package com.babyjuan.house.rest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.babyjuan.house.common.utils.JsonUtils;
import com.babyjuan.house.contract.api.HouseApiService;
import com.babyjuan.house.contract.service.CrawlerService;
import com.babyjuan.house.contract.service.SecondHandHouseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HouseRestApplicationTests {

    @Reference
    private HouseApiService houseApiService;

    @Reference
    private SecondHandHouseService secondHandHouseService;

    @Reference
    private CrawlerService crawlerService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        System.out.println(houseApiService.test());
    }

    @Test
    public void testSecondHouse() {
        System.out.println(JsonUtils.objectToJson(secondHandHouseService.getAllDistricts()));
        System.out.println(JsonUtils.objectToJson(secondHandHouseService.getSecondHouseList(0, 3)));
    }

    @Test
    public void testCrawler() {
        System.out.println(JsonUtils.objectToJson(crawlerService.secondHandHouseCrawlerStatus()));
    }

}
