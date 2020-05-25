package com.babyjuan.house.service.impl;

import com.babyjuan.house.service.dto.HouseResult;
import com.babyjuan.house.task.spider.SpiderState;
import com.babyjuan.house.task.spider.config.LianjiaConst;
import com.babyjuan.house.manager.ShDealSpiderThreadManager;
import com.babyjuan.house.service.CrawlerService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 16:07
 * @Description:
 */
@Service
public class ShHouseDealCrawlerServiceImpl implements CrawlerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShHouseDealCrawlerServiceImpl.class);

    @Resource(name = "shDealSpider")
    private Spider shDealSpider;
    @Autowired
    private ShDealSpiderThreadManager shDealSpiderThreadManager;
    @Autowired
    private LianjiaConst lianjiaConst;

    @Override
    public HouseResult start(int repeatTimes) {
        if (shDealSpiderThreadManager.isSpiderRunnnig()) {
            LOGGER.info("spider is running");
            return HouseResult.ok("spider is running");
        }
        LOGGER.info("spider is starting, for {} turn", repeatTimes);
        shDealSpiderThreadManager.start(repeatTimes, readStartUrls());
        return HouseResult.ok("spider started");
    }

    private List<String> readStartUrls() {
        List<String> districts = lianjiaConst.getShDealDistricts();
        List<String> urlList = new ArrayList<>();
        for (String district : districts) {
            if(district.isEmpty()){
                continue;
            }
            String url = lianjiaConst.getShDealCityRoot() + district;
            urlList.add(url);
        }
        LOGGER.info("root url: {}", urlList);
        return urlList;
    }

    @Deprecated
    @Override
    public void stop() {
    }

    @Override
    public SpiderState status() {
        SpiderState spiderState = new SpiderState();
        if (shDealSpider != null) {
            spiderState.setPageCount(shDealSpider.getPageCount());
            spiderState.setStartTime(shDealSpider.getStartTime());
            spiderState.setThreadAlive(shDealSpider.getThreadAlive());
            spiderState.setStatus(shDealSpider.getStatus());
        }
        return spiderState;
    }

    @Override
    public void test(String url, int repeatTimes) {
        LOGGER.debug("spider start run");
        shDealSpiderThreadManager.start(repeatTimes, Arrays.asList(url));
    }
}
