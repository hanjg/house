package com.babyjuan.house.contract.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/9 18:25
 * @Description:
 */
public class SpiderStateDTO implements Serializable {

    private static final long serialVersionUID = 5856199255644954999L;

    private String status;

    private long pageCount;

    private Date startTime;

    private long duration;

    private double millSecondsPerPage;

    private int threadAlive;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public double getMillSecondsPerPage() {
        return millSecondsPerPage;
    }

    public void setMillSecondsPerPage(double millSecondsPerPage) {
        this.millSecondsPerPage = millSecondsPerPage;
    }

    @Override
    public String toString() {
        return "SpiderState{" +
                "status=" + status +
                ", pageCount=" + pageCount +
                ", startTime=" + startTime +
                ", duration=" + duration +
                ", millSecondsPerPage=" + millSecondsPerPage +
                ", threadAlive=" + threadAlive +
                '}';
    }
}
