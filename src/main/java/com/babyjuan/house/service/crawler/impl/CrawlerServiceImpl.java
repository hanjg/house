package com.babyjuan.house.service.crawler.impl;

import com.babyjuan.house.dao.entity.RentingHouse;
import com.babyjuan.house.dao.entity.RentingHouseExample;
import com.babyjuan.house.dao.mapper.RentingHouseMapper;
import com.babyjuan.house.service.crawler.CrawlerService;
import com.babyjuan.house.service.crawler.model.SpiderState;
import com.babyjuan.house.service.webmagic.ProxyPool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.Scheduler;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 16:07
 * @Description:
 */
@Service
public class CrawlerServiceImpl implements CrawlerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerServiceImpl.class);

    @Autowired
    private PageProcessor pageProcessor;

    @Autowired
    private Pipeline pipeline;
    @Autowired
    private HttpClientDownloader downloader;
    @Autowired
    private Scheduler scheduler;

    @Value("${lianjia.city.rent.root}")
    private String LIANJIA_NJ_RENT_ROOT;
    @Value("${lianjia.city.districts}")
    private String LIANJIA_DISTRICTS;
    @Value("${spider.threadnum}")
    private Integer SPIDER_THREAD_NUM;

    private Spider spider;

    @Autowired
    private RentingHouseMapper rentingHouseMapper;

    @Autowired
    private ProxyPool proxyPool;

    @Override
    public void run() {
        if (spider != null) {
            destroySpider();
        }
        initSpider(getStartUrls());
        spider.run();
    }

    private void destroySpider() {
        LOGGER.info("destroy spider");
        //销毁没有完成的爬虫
        spider.close();
        spider = null;
    }

    @Override
    public void start() {
        if (spider != null) {
            destroySpider();
        }
        initSpider(getStartUrls());
        spider.start();
    }

    private void initSpider(List<String> startUrls) {
        LOGGER.info("spider initing");
        spider = Spider.create(pageProcessor);
        spider.addPipeline(pipeline);
        downloader.setProxyProvider(proxyPool);
        spider.setDownloader(downloader);
        spider.setScheduler(scheduler);
        spider.thread(SPIDER_THREAD_NUM);
        for (String url : startUrls) {
            spider.addUrl(url);
        }

        //开始爬取数据之前，将所有的房屋信息设置为过时的
        try {
            RentingHouseExample example = new RentingHouseExample();
            RentingHouse rentingHouse = new RentingHouse();
            rentingHouse.setIsNew(false);
            rentingHouseMapper.updateByExampleSelective(rentingHouse, example);
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
    }

    @Override
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
    public void test(String url) {
        LOGGER.debug("spider start run");
        initSpider(Arrays.asList(url));
        spider.run();
    }

    private List<String> getStartUrls() {
        String[] districts = LIANJIA_DISTRICTS.trim().split(",");
        List<String> urlList = new ArrayList<>();
        for (String district : districts) {
            String url = LIANJIA_NJ_RENT_ROOT + district;
            urlList.add(url);
        }
        return urlList;
    }

}
