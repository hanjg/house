package com.babyjuan.house.service.crawler.impl;

import com.babyjuan.house.common.HouseResult;
import com.babyjuan.house.common.enums.RecordStatus;
import com.babyjuan.house.dao.entity.CommunityExample;
import com.babyjuan.house.dao.entity.RentingHouse;
import com.babyjuan.house.dao.entity.RentingHouseExample;
import com.babyjuan.house.dao.entity.RentingHouseExample.Criteria;
import com.babyjuan.house.dao.mapper.CommunityMapper;
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
import us.codecraft.webmagic.Spider.Status;
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
    private CommunityMapper communityMapper;

    @Autowired
    private ProxyPool proxyPool;

    @Override
    public HouseResult run() {
        if (spider != null && !spider.getStatus().equals(Status.Stopped)) {
            return HouseResult.ok("爬虫正在运行");
        }
        initSpider(getStartUrls());
        spider.run();
        updateStatus();
        return HouseResult.ok("爬虫启动");
    }

    @Deprecated
    private void destroySpider() {
        LOGGER.info("destroy spider");
        //销毁没有完成的爬虫
        spider.close();
        spider = null;
    }

    @Override
    public HouseResult start() {
        if (spider != null && !spider.getStatus().equals(Status.Stopped)) {
            return HouseResult.ok("爬虫正在运行");
        }
        initSpider(getStartUrls());
        spider.start();
        updateStatus();
        return HouseResult.ok("爬虫启动");
    }

    private void initSpider(List<String> startUrls) {
        if (spider == null) {
            LOGGER.info("spider initing");
            spider = Spider.create(pageProcessor);
            spider.addPipeline(pipeline);
            downloader.setProxyProvider(proxyPool);
            spider.setDownloader(downloader);
            spider.setScheduler(scheduler);
            spider.thread(SPIDER_THREAD_NUM);

        }
        for (String url : startUrls) {
            spider.addUrl(url);
        }
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

    private void updateStatus() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (spider != null && spider.getStatus().equals(Status.Stopped)) {
                            CommunityExample communityExample = new CommunityExample();
                            CommunityExample.Criteria communityCriteria = communityExample.createCriteria();
                            communityCriteria.andStatusEqualTo(RecordStatus.UPDATING.getStatus());
                            if (!communityMapper.selectByExample(communityExample).isEmpty()) {
                                communityMapper.updateStatus();
                            }

                            RentingHouseExample rentingHouseExample = new RentingHouseExample();
                            Criteria renthouseCriteria = rentingHouseExample.createCriteria();
                            renthouseCriteria.andStatusEqualTo(RecordStatus.UPDATING.getStatus());
                            if (!rentingHouseMapper.selectByExample(rentingHouseExample).isEmpty()) {
                                rentingHouseMapper.updateStatus();
                            }
                            break;
                        }
                        Thread.sleep(60 * 1000);
                    }
                } catch (InterruptedException e) {
                    LOGGER.warn(e.toString());
                }
            }
        });
        thread.setDaemon(false);
        thread.start();
    }

}
