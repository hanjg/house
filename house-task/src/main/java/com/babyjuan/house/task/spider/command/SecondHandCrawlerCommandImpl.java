package com.babyjuan.house.task.spider.command;

import com.babyjuan.house.task.spider.config.LianjiaConst;
import com.babyjuan.house.task.spider.logic.SecondHandSpiderLogic;
import com.babyjuan.house.task.spider.webmagic.SpiderState;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;
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
public class SecondHandCrawlerCommandImpl implements CrawlerCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecondHandCrawlerCommandImpl.class);

    private Date startTime = new Date();

    @Autowired
    @Qualifier("secondHandHouseSpider")
    private Spider secondHandHouseSpider;
    @Autowired
    private SecondHandSpiderLogic spiderThreadLogic;

    @Autowired
    private LianjiaConst lianjiaConst;

    @Override
    public String start(int repeatTimes) {
        if (spiderThreadLogic.isSpiderRunnnig()) {
            LOGGER.info("spider is running");
            return "spider is running";
        }
        LOGGER.info("spider is starting, for {} turn", repeatTimes);
        spiderThreadLogic.start(repeatTimes, readStartUrls());
        return "spider started";
    }

    @Override
    public String stop() {
        if (spiderThreadLogic.isSpiderRunnnig()) {
            LOGGER.info("spider is stopping");
            spiderThreadLogic.stop();
            return "spider stopped";
        }
        return "spider already stoppped";
    }

    private List<String> readStartUrls() {
        List<String> districts = lianjiaConst.getSecondHandDistricts();
        List<String> urlList = new ArrayList<>();
        for (String district : districts) {
            if (district.isEmpty()) {
                continue;
            }
            String url = lianjiaConst.getSecondHandCityRoot() + district;
            urlList.add(url);
        }
        LOGGER.info("root url: {}", urlList);
        return urlList;
    }

    @Override
    public SpiderState status() {
        SpiderState spiderState = new SpiderState();
        if (secondHandHouseSpider != null) {
            spiderState.setPageCount(secondHandHouseSpider.getPageCount());
            spiderState.setStartTime(secondHandHouseSpider.getStartTime());
            spiderState.setThreadAlive(secondHandHouseSpider.getThreadAlive());
            spiderState.setStatus(secondHandHouseSpider.getStatus());
            long duration = System.currentTimeMillis() - startTime.getTime();
            spiderState.setDuration(duration);
            long pageCount = secondHandHouseSpider.getPageCount();
            double secondsPerPage = pageCount < 0 ? 0 : NumberUtils
                    .toScaledBigDecimal((double) duration / pageCount, 2, RoundingMode.HALF_UP).doubleValue();
            spiderState.setMillSecondsPerPage(pageCount == 0 ? -1 : secondsPerPage);
        }
        return spiderState;
    }

    @Override
    public void test(String url, int repeatTimes) {
        LOGGER.debug("spider start run");
        spiderThreadLogic.start(repeatTimes, Arrays.asList(url));
    }
}
