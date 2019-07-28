package com.babyjuan.house.spider;

import com.babyjuan.house.HouseApplicationTests;
import com.babyjuan.house.common.utils.ProxyUtil;
import com.babyjuan.house.spider.service.CrawlerService;
import com.babyjuan.house.spider.service.ProxyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.utils.ProxyUtils;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/10 17:57
 * @Description:
 */
public class ProxyTest extends HouseApplicationTests {

    @Autowired
    private ProxyService proxyService;
    @Autowired
    @Qualifier("crawlerServiceImpl")
    private CrawlerService crawlerService;
    @Autowired
    @Qualifier("secondHandCrawlerServiceImpl")
    private CrawlerService secondHandCrawlerService;

    private String targetUrl = "https://nj.lianjia.com/zufang/jianye/";

    @Test
    public void testReach() {
        String[] urls = new String[]{
                "127.0.0.1:3306",
                "122.114.31.177:808",
                "119.10.67.144:808",
                "115.233.209.134:3128"
        };
        for (String url : urls) {
            System.out.println(url + ": ");
            String[] tokens = url.split(": ");
            String host = tokens[0];
            int port = Integer.valueOf(tokens[1]);
            boolean canreach = ProxyUtils.validateProxy(new Proxy(host, port));
            System.out.println("webmagic: " + canreach);

            System.out.println("csdn: " + ProxyUtil.isConnServerByHttp("http://" + url));
        }
    }

    @Test
    public void runProxy() throws InterruptedException {
        proxyService.run();
    }

    @Test
    public void start() throws InterruptedException {
        proxyService.start();
        crawlerService.start(1);
        Thread.sleep(60 * 1000);
    }

    @Test
    public void start2() throws InterruptedException {
        secondHandCrawlerService.start(1);
        Thread.sleep(60 * 1000);
    }
}
