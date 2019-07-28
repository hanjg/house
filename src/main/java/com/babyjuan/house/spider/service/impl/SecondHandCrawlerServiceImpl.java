package com.babyjuan.house.spider.service.impl;

import com.babyjuan.house.common.HouseResult;
import com.babyjuan.house.common.SpiderState;
import com.babyjuan.house.common.constant.LianjiaConst;
import com.babyjuan.house.spider.manager.SecondHandSpiderThreadManager;
import com.babyjuan.house.spider.service.CrawlerService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 16:07
 * @Description:
 */
@Service
public class SecondHandCrawlerServiceImpl implements CrawlerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecondHandCrawlerServiceImpl.class);

    @Autowired
    @Qualifier("secondHandHouseSpider")
    private Spider secondHandHouseSpider;
    @Autowired
    private SecondHandSpiderThreadManager spiderThreadManager;

    @Autowired
    private LianjiaConst lianjiaConst;

    @Override
    public HouseResult start(int repeatTimes) {
        if (spiderThreadManager.isSpiderRunnnig()) {
            LOGGER.info("spider is running");
            return HouseResult.ok("spider is running");
        }
        LOGGER.info("spider is starting, for {} turn", repeatTimes);
        spiderThreadManager.start(repeatTimes, readStartUrls());
        return HouseResult.ok("spider started");
    }

    private List<String> readStartUrls() {
        List<String> districts = lianjiaConst.getSecondHandDistricts();
        List<String> urlList = new ArrayList<>();
        for (String district : districts) {
            if(district.isEmpty()){
                continue;
            }
            String url = lianjiaConst.getSecondHandCityRoot() + district;
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
        if (secondHandHouseSpider != null) {
            spiderState.setPageCount(secondHandHouseSpider.getPageCount());
            spiderState.setStartTime(secondHandHouseSpider.getStartTime());
            spiderState.setThreadAlive(secondHandHouseSpider.getThreadAlive());
            spiderState.setStatus(secondHandHouseSpider.getStatus());
        }
        return spiderState;
    }

    @Override
    public void test(String url, int repeatTimes) {
        LOGGER.debug("spider start run");
        spiderThreadManager.start(repeatTimes, Arrays.asList(url));
    }
}
