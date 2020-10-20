package com.babyjuan.house.task.spider.webmagic;

import com.babyjuan.house.task.spider.config.CrawlerConst;
import com.babyjuan.house.task.spider.config.LianjiaConst;
import com.babyjuan.house.task.spider.webmagic.pageprocessor.LianjiaSecondHandPageProcessor;
import com.babyjuan.house.task.spider.webmagic.pageprocessor.LianjiaShDealPageProcessor;
import com.babyjuan.house.task.spider.webmagic.pipeline.LianjiaSecondHandDbPipeLine;
import com.babyjuan.house.task.spider.webmagic.pipeline.LianjiaShDealDbPipeLine;
import com.babyjuan.house.task.spider.webmagic.scheduler.DuplicateQueueScheduler;
import javax.annotation.Resource;
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
    private CrawlerConst crawlerConst;

    @Resource(name = "secondHandPageProcessor")
    private PageProcessor secondHandPageProcessor;
    @Resource(name = "shDealPageProcessor")
    private PageProcessor shDealPageProcessor;

    @Resource(name = "secondHandHousePipeline")
    private Pipeline secondHandHousePipeline;
    @Resource(name = "shDealPipeline")
    private Pipeline shDealPipeline;

    @Resource(name = "secondHandHouseDownloader")
    private HttpClientDownloader secondHandHouseDownloader;
    @Resource(name = "shHouseDealDownloader")
    private HttpClientDownloader shHouseDealDownloader;

    @Resource(name = "secondHandHouseScheduler")
    private Scheduler secondHandHouseScheduler;
    @Resource(name = "shDealScheduler")
    private Scheduler shDealScheduler;

    @Bean
    public Spider secondHandHouseSpider() {
        Spider spider = Spider.create(secondHandPageProcessor);
        spider.addPipeline(secondHandHousePipeline);
        spider.setDownloader(secondHandHouseDownloader);
        spider.setScheduler(secondHandHouseScheduler);
        spider.thread(crawlerConst.getThreadNum());
        return spider;
    }

    @Bean
    public Spider shDealSpider() {
        Spider spider = Spider.create(shDealPageProcessor);
        spider.addPipeline(shDealPipeline);
        spider.setDownloader(shHouseDealDownloader);
        spider.setScheduler(shDealScheduler);
        spider.thread(crawlerConst.getThreadNum());
        return spider;
    }

    @Bean
    public Pipeline secondHandHousePipeline() {
        return new LianjiaSecondHandDbPipeLine();
    }

    @Bean
    public Pipeline shDealPipeline() {
        return new LianjiaShDealDbPipeLine();
    }

    @Bean
    public Scheduler secondHandHouseScheduler() {
        return new DuplicateQueueScheduler();
    }

    @Bean
    public Scheduler shDealScheduler() {
        return new DuplicateQueueScheduler();
    }

    @Bean
    public PageProcessor secondHandPageProcessor(@Autowired LianjiaConst lianjiaConst,
            @Autowired CrawlerConst crawlerConst) {
        LianjiaSecondHandPageProcessor pageProcessor = new LianjiaSecondHandPageProcessor(crawlerConst.getSleepTimes(),
                crawlerConst.getRetryTimes());
        pageProcessor.setSecondHandCityRoot(lianjiaConst.getSecondHandCityRoot());
        pageProcessor.setCity(lianjiaConst.getSecondHandCityName());
        return pageProcessor;
    }

    @Bean
    public PageProcessor shDealPageProcessor(@Autowired LianjiaConst lianjiaConst,
            @Autowired CrawlerConst crawlerConst) {
        LianjiaShDealPageProcessor pageProcessor = new LianjiaShDealPageProcessor(crawlerConst.getSleepTimes(),
                crawlerConst.getRetryTimes());
        pageProcessor.setShDealCityRoot(lianjiaConst.getShDealCityRoot());
        pageProcessor.setCity(lianjiaConst.getShDealCityName());
        return pageProcessor;
    }

    @Bean
    public HttpClientDownloader secondHandHouseDownloader() {
        return new HttpClientDownloader();
    }

    @Bean
    public HttpClientDownloader shHouseDealDownloader() {
        return new HttpClientDownloader();
    }
}
