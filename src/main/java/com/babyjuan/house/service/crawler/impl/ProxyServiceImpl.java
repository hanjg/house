package com.babyjuan.house.service.crawler.impl;

import com.alibaba.fastjson.JSON;
import com.babyjuan.house.service.crawler.ProxyService;
import com.babyjuan.house.service.crawler.impl.webmagic.ProxyPool;
import com.babyjuan.house.service.crawler.model.CrawlerConst;
import com.babyjuan.house.service.crawler.model.LianjiaConst;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.proxy.Proxy;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/10 18:36
 * @Description:
 */
@Service
public class ProxyServiceImpl implements ProxyService, Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyServiceImpl.class);

    @Autowired
    private ProxyPool proxyPool;

    @Autowired
    private LianjiaConst lianjiaConst;
    @Autowired
    private CrawlerConst crawlerConst;

    private HttpClient testClient;

    @Override
    public void start() {
        Thread thread = new Thread(this);
        thread.setDaemon(false);
        thread.start();
    }

    private void getProxyFromXici() {
        int currentPage = 1;
        int urlCount = 0;
        while (true) {
            String url = crawlerConst.getXiciRoot() + currentPage;
            LOGGER.info("get proxy from: {}", url);
            try {
                Document document = Jsoup.connect(url).timeout(3 * 1000).get();
                Elements trs = document.getElementsByTag("tr");
                if (trs == null || trs.size() < 1) {
                    break;
                }
                for (int i = 1; i < trs.size(); i++) {
                    try {
                        LOGGER.debug("get url {}", ++urlCount);
                        Elements tds = trs.get(i).getElementsByTag("td");
                        Proxy proxy = new Proxy(tds.get(1).text(), Integer.valueOf(tds.get(2).text()));
                        if (!proxyPool.contain(proxy) && canUse(proxy)) {
                            proxyPool.add(proxy);
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            LOGGER.error(e.toString());
                        }
                    } catch (Exception e) {
                        LOGGER.error(e.toString());
                    }
                }
            } catch (Exception e) {
                LOGGER.error(e.toString());
            }
            currentPage++;
        }
    }

    private void getProxyFromMimiIp() {
        int currentPage = 1;
        int urlCount = 0;
        while (true) {
            String url = crawlerConst.getMimiipRoot() + currentPage;
            LOGGER.info("get proxy from: {}", url);
            try {
                Document document = Jsoup.connect(url).timeout(3 * 1000).get();
                Elements elements = document.select("table[class=list] tr");
                for (int i = 1; i < elements.size(); i++) {
                    try {
                        LOGGER.debug("get url {}", ++urlCount);
                        String ip = elements.get(i).select("td:eq(0)").first().text();
                        String port = elements.get(i).select("td:eq(1)").first().text();
                        Proxy proxy = new Proxy(ip, Integer.valueOf(port));
                        if (!proxyPool.contain(proxy) && canUse(proxy)) {
                            proxyPool.add(proxy);
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            LOGGER.error(e.toString());
                        }
                    } catch (Exception e) {
                        LOGGER.error(e.toString());
                    }
                }
            } catch (Exception e) {
                LOGGER.error(e.toString());
            }
            currentPage++;
        }
    }

    private boolean canUse(Proxy proxy) {
        LOGGER.debug("text proxy {}", proxy.getHost() + ":" + proxy.getPort());
        HttpClient httpClient = getTestClient();
        LOGGER.debug("finish create client");
        HttpGet httpGet = getTestRequest(proxy);
        LOGGER.debug("finish create request");

        boolean canUse = false;
        try {
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                canUse = true;
            }
            LOGGER.info("proxy {} can use", proxy.getHost() + ":" + proxy.getPort());
        } catch (IOException e) {
            LOGGER.warn("proxy {} can not use", proxy.getHost() + ":" + proxy.getPort());
        } finally {
            httpGet.releaseConnection();
        }
        return canUse;
    }

    private HttpClient getTestClient() {
        if (testClient == null) {
            SocketConfig.Builder socketConfigBuilder = SocketConfig.custom();
            socketConfigBuilder.setSoKeepAlive(true).setTcpNoDelay(true);
            socketConfigBuilder.setSoTimeout(10 * 1000);
            SocketConfig socketConfig = socketConfigBuilder.build();
            testClient = HttpClients.custom().setDefaultSocketConfig(socketConfig).build();
        }
        return testClient;
    }

    private HttpGet getTestRequest(Proxy proxy) {
        LOGGER.debug("create test request: {}", proxy);
        RequestConfig config = RequestConfig.custom().setSocketTimeout(10000).
                setConnectTimeout(10000).
                setConnectionRequestTimeout(10000).
                setCookieSpec(CookieSpecs.STANDARD).
                setProxy(new HttpHost(proxy.getHost(), proxy.getPort())).build();
        HttpGet httpGet = new HttpGet(lianjiaConst.getRentCityRoot());
        httpGet.setConfig(config);
        return httpGet;
    }

    @Override
    public void run() {
        File proxyFile = new File(crawlerConst.getProxyFile());

        //反序列化可用Proxy
        String json = null;
        try {
            json = FileUtils.readFileToString(proxyFile);
        } catch (IOException e) {
            LOGGER.warn(e.toString());
        }
        if (json != null && !json.isEmpty()) {
            List<Proxy> earlyProxyList = JSON.parseArray(json, Proxy.class);
            for (Proxy proxy : earlyProxyList) {
                proxyPool.add(proxy);
            }
            LOGGER.info("read proxy: {}", earlyProxyList.size());
        } else {
            LOGGER.info("read proxy: {}", 0);
        }

        getProxyFromXici();

        //序列化可用proxy
        List<Proxy> currentProxyList = new ArrayList<>();
        for (Proxy proxy : proxyPool) {
            currentProxyList.add(proxy);
        }
        json = JSON.toJSONString(currentProxyList);
        try {
            FileUtils.writeStringToFile(proxyFile, json);
        } catch (IOException e) {
            LOGGER.warn(e.toString());
        }
        LOGGER.info("write proxy: {}", currentProxyList.size());
    }
}
