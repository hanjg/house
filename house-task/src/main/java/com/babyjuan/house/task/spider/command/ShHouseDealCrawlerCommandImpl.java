package com.babyjuan.house.task.spider.command;

import com.babyjuan.house.task.spider.webmagic.SpiderState;
import com.babyjuan.house.task.spider.config.LianjiaConst;
import com.babyjuan.house.task.spider.logic.ShDealSpiderThreadLogic;
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
public class ShHouseDealCrawlerCommandImpl implements CrawlerCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShHouseDealCrawlerCommandImpl.class);

    @Resource(name = "shDealSpider")
    private Spider shDealSpider;
    @Autowired
    private ShDealSpiderThreadLogic shDealSpiderThreadLogic;
    @Autowired
    private LianjiaConst lianjiaConst;

    @Override
    public String start(int repeatTimes) {
        if (shDealSpiderThreadLogic.isSpiderRunnnig()) {
            LOGGER.info("spider is running");
            return "spider is running";
        }
        LOGGER.info("spider is starting, for {} turn", repeatTimes);
        shDealSpiderThreadLogic.start(repeatTimes, readStartUrls());
        return "spider started";
    }

    @Override
    public String stop() {
        if (shDealSpiderThreadLogic.isSpiderRunnnig()) {
            LOGGER.info("spider is stopping");
            shDealSpider.stop();
            return "spider stopped";
        }
        return "spider already stoppped";
    }

    private List<String> readStartUrls() {
        List<String> districts = lianjiaConst.getShDealDistricts();
        List<String> urlList = new ArrayList<>();
        for (String district : districts) {
            if (district.isEmpty()) {
                continue;
            }
            String url = lianjiaConst.getShDealCityRoot() + district;
            urlList.add(url);
        }
        LOGGER.info("root url: {}", urlList);
        return urlList;
    }

    @Override
    public SpiderState status() {
        SpiderState spiderState = new SpiderState();
        if (shDealSpider != null) {
            spiderState.setPageCount(shDealSpider.getPageCount());
            spiderState.setStartTime(shDealSpider.getStartTime());
            spiderState.setThreadAlive(shDealSpider.getThreadAlive());
            spiderState.setStatus(shDealSpider.getStatus());
            long duration = System.currentTimeMillis() - shDealSpider.getStartTime().getTime();
            spiderState.setDuration(duration);
            long pageCount = shDealSpider.getPageCount();
            spiderState.setMillSecondsPerPage(pageCount == 0 ? -1 : (double) duration / pageCount);
        }
        return spiderState;
    }

    @Override
    public void test(String url, int repeatTimes) {
        LOGGER.debug("spider start run");
        shDealSpiderThreadLogic.start(repeatTimes, Arrays.asList(url));
    }
}
