package com.babyjuan.house.service.crawler.impl.webmagic;

import com.babyjuan.house.service.crawler.model.CrawlerConst;
import com.babyjuan.house.service.crawler.model.LianjiaConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.Scheduler;

/**
 * @Author: hjg
 * @Date: Create in 2018/12/9 13:49
 * @Description:
 */
@Configuration
public class WebmagicConfig {

    @Autowired
    private LianjiaConst lianjiaConst;
    @Autowired
    private CrawlerConst crawlerConst;

    @Autowired
    private PageProcessor pageProcessor;
    @Autowired
    private Pipeline pipeline;
    @Autowired
    private HttpClientDownloader downloader;
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private ProxyPool proxyPool;

    @Bean
    public Spider spider() {
        Spider spider = us.codecraft.webmagic.Spider.create(pageProcessor);
        spider.addPipeline(pipeline);
        downloader.setProxyProvider(proxyPool);
        spider.setDownloader(downloader);
        spider.setScheduler(scheduler);
        spider.thread(crawlerConst.getThreadNum());
        return spider;
    }

    @Bean
    public Pipeline pipeline() {
        return new LianjiaDbPipeLine();
    }

    @Bean
    public Scheduler scheduler() {
        return new DuplicateQueueScheduler();
    }

    @Bean
    public PageProcessor pageProcessor() {
        LianjiaPageProcessor pageProcessor = new LianjiaPageProcessor(crawlerConst.getSleepTimes(),
                crawlerConst.getRetryTimes());
        pageProcessor.setCityRentRoot(lianjiaConst.getRentCityRoot());
        pageProcessor.setCity(lianjiaConst.getCityName());
        return pageProcessor;
    }

    @Bean
    public ProxyPool proxyPool() {
        return new ProxyPool();
    }

    @Bean
    public HttpClientDownloader httpClientDownloader() {
        return new HttpClientDownloader();
    }
}
