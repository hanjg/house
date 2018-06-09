package com.babyjuan.house.service.crawler.model;

import java.util.Date;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Spider.Status;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/9 18:25
 * @Description:
 */
public class SpiderState {

    private Spider.Status status;
    private Date startTime;
    private long pageCount;
    private int threadAlive;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public int getThreadAlive() {
        return threadAlive;
    }

    public void setThreadAlive(int threadAlive) {
        this.threadAlive = threadAlive;
    }
}
