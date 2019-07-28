package com.babyjuan.house.spider.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: hjg
 * @Date: Create in 2018/12/12 15:23
 * @Description:
 */
@Component
public class CrawlerConst {

    @Value("${spider.threadnum}")
    private Integer threadNum;
    @Value("${spider.retryTimes}")
    private Integer retryTimes;
    @Value("${spider.sleepTime}")
    private Integer sleepTimes;

    @Value("${spider.proxy.xiciRoot}")
    private String xiciRoot;
    @Value("${spider.proxy.mimiipRoot}")
    private String mimiipRoot;
    @Value("${spider.proxy.file}")
    private String proxyFile;

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    public Integer getSleepTimes() {
        return sleepTimes;
    }

    public void setSleepTimes(Integer sleepTimes) {
        this.sleepTimes = sleepTimes;
    }

    public Integer getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(Integer threadNum) {
        this.threadNum = threadNum;
    }

    public String getXiciRoot() {
        return xiciRoot;
    }

    public void setXiciRoot(String xiciRoot) {
        this.xiciRoot = xiciRoot;
    }

    public String getMimiipRoot() {
        return mimiipRoot;
    }

    public void setMimiipRoot(String mimiipRoot) {
        this.mimiipRoot = mimiipRoot;
    }

    public String getProxyFile() {
        return proxyFile;
    }

    public void setProxyFile(String proxyFile) {
        this.proxyFile = proxyFile;
    }
}
