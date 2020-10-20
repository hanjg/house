package com.babyjuan.house.task.spider.logic;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Spider.Status;

/**
 * @Author: hjg
 * @Date: Create in 2018/12/10 19:51
 * @Description:
 */
@Service
public class ShDealSpiderThreadLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShDealSpiderThreadLogic.class);

    /**
     * 爬虫和更新状态线程的运行状况
     */
    private volatile boolean spiderRunnnig = false;

    @Resource(name = "shDealSpider")
    private Spider shDealSpider;

    public void stop() {
        shDealSpider.stop();
        spiderRunnnig = false;
    }

    public void start(final int repeatTimes, List<String> rootUrls) {
        spiderRunnnig = true;
        int count = repeatTimes;
        while (count-- > 0) {
            crawlStart(rootUrls);
            LOGGER.warn("spider run once.");
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        spiderRunnnig = false;
    }

    private void crawlStart(List<String> urlList) {
        try {
            shDealSpider.addUrl(urlList.toArray(new String[urlList.size()]));
            shDealSpider.start();
            while (true) {
                Thread.sleep(10 * 1000);
                if (shDealSpider.getStatus().equals(Status.Stopped)) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isSpiderRunnnig() {
        return spiderRunnnig;
    }
}
