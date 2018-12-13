package com.babyjuan.house.service.crawler.impl;

import com.babyjuan.house.common.HouseResult;
import com.babyjuan.house.service.crawler.CrawlerService;
import com.babyjuan.house.service.crawler.impl.action.SpiderThreadManager;
import com.babyjuan.house.service.crawler.model.LianjiaConst;
import com.babyjuan.house.service.crawler.model.SpiderState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class CrawlerServiceImpl implements CrawlerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerServiceImpl.class);

    @Autowired
    private Spider spider;
    @Autowired
    private SpiderThreadManager spiderThreadManager;

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
        List<String> districts = lianjiaConst.getDistricts();
        List<String> urlList = new ArrayList<>();
        for (String district : districts) {
            String url = lianjiaConst.getRentCityRoot() + district;
            urlList.add(url);
        }
        LOGGER.info("root url: {}", urlList);
        return urlList;
    }

    @Deprecated
    public void stop() {
        LOGGER.debug("spider start stop");
        if (spider != null) {
            spider.stop();
        }
    }

    @Override
    public SpiderState status() {
        SpiderState spiderState = new SpiderState();
        if (spider != null) {
            spiderState.setPageCount(spider.getPageCount());
            spiderState.setStartTime(spider.getStartTime());
            spiderState.setThreadAlive(spider.getThreadAlive());
            spiderState.setStatus(spider.getStatus());
        }
        return spiderState;
    }

    @Override
    public void test(String url, int repeatTimes) {
        LOGGER.debug("spider start run");
        spiderThreadManager.start(repeatTimes, Arrays.asList(url));
    }


}
