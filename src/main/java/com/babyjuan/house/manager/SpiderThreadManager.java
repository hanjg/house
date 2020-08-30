package com.babyjuan.house.manager;

import com.babyjuan.house.common.enums.RecordStatus;
import com.babyjuan.house.repository.mysql.mapper.CommunityMapper;
import com.babyjuan.house.repository.mysql.mapper.RentingHouseMapper;
import com.babyjuan.house.repository.mysql.entity.CommunityExample;
import com.babyjuan.house.repository.mysql.entity.RentingHouseExample;
import com.babyjuan.house.repository.mysql.entity.RentingHouseExample.Criteria;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Spider.Status;

/**
 * @Author: hjg
 * @Date: Create in 2018/12/10 19:51
 * @Description:
 */
@Service
public class SpiderThreadManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpiderThreadManager.class);

    private ExecutorService threadPool = Executors.newCachedThreadPool();

    /**
     * 爬虫和更新状态线程的运行状况
     */
    private volatile boolean spiderRunnnig = false;

    @Autowired
    @Qualifier("spider")
    private Spider spider;
    @Autowired
    @Qualifier("crawlProcess")
    private Action crawlAction;
    @Autowired
    @Qualifier("crawlProcess")
    private Action updateStatusAction;

    @Autowired
    private RentingHouseMapper rentingHouseMapper;
    @Autowired
    private CommunityMapper communityMapper;

    public void start(final int repeatTimes, List<String> rootUrls) {
        spiderRunnnig = true;
        int count = repeatTimes;
        while (count-- > 0) {
            updateStatusThreadStart();
            crawlStart(rootUrls);
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
            spider.addUrl(urlList.toArray(new String[urlList.size()]));
            spider.start();
            while (true) {
                Thread.sleep(10 * 1000);
                if (spider.getStatus().equals(Status.Stopped)) {
                    break;
                }
            }
            crawlAction.countDown();
            updateStatusAction.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 爬取所有信息之后更新记录的状态
     */
    private void updateStatusThreadStart() {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    LOGGER.info("update status thread start.");
                    crawlAction.await();

                    int communityCount = 0;
                    int houseCount = 0;
                    CommunityExample communityExample = new CommunityExample();
                    CommunityExample.Criteria communityCriteria = communityExample.createCriteria();
                    communityCriteria.andStatusEqualTo(RecordStatus.UPDATING.getStatus());
                    if (!communityMapper.selectByExample(communityExample).isEmpty()) {
                        communityCount = communityMapper.updateStatus();
                    }

                    RentingHouseExample rentingHouseExample = new RentingHouseExample();
                    Criteria renthouseCriteria = rentingHouseExample.createCriteria();
                    renthouseCriteria.andStatusEqualTo(RecordStatus.UPDATING.getStatus());
                    if (!rentingHouseMapper.selectByExample(rentingHouseExample).isEmpty()) {
                        houseCount = rentingHouseMapper.updateStatus();
                    }
                    LOGGER.info("update status, community {}, house: {}", communityCount, houseCount);

                    updateStatusAction.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public boolean isSpiderRunnnig() {
        return spiderRunnnig;
    }
}
