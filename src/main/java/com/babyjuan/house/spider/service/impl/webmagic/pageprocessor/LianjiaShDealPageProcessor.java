package com.babyjuan.house.spider.service.impl.webmagic.pageprocessor;

import com.babyjuan.house.spider.service.impl.webmagic.LianjiaFieldInfo;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 16:18
 * @Description:
 */
public class LianjiaShDealPageProcessor implements PageProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LianjiaShDealPageProcessor.class);
    private Site site;
    private String shDealCityRoot;
    private String city;
    private Pattern pricePattern = Pattern
            .compile("<divclass=\"price\"><spanclass=\"dealTotalPrice\"><i>(.+?)</i>万</span><b>(.+?)</b>元/平</div>");
    private Pattern msgPattern = Pattern.compile(
            "<divclass=\"msg\"><span><label>(.+?)</label>挂牌价格（万）</span><span><label>(.+?)</label>成交周期（天）</span><span><label>(.+?)</label>调价（次）</span><span><label>(.+?)</label>带看（次）</span><span><label>(.+?)</label>关注（人）</span><span><label>(.+?)</label>浏览（次）</span>");

    public LianjiaShDealPageProcessor(int sleepTime, int retryTimes) {
        this.site = Site.me().setRetryTimes(retryTimes).setSleepTime(sleepTime).setDisableCookieManagement(true);
    }

    @Override
    public void process(Page page) {
        String url = page.getUrl().toString();
        if (url.contains("chengjiao") && url.endsWith(".html")) {
            //交易信息详情页面
            processDetail(page);
        } else if (url.contains("chengjiao")) {
            //分类检索页面
            processListPage(page);
        } else {
            //无关页面
            processUnknownPage(page);
        }
    }

    private void processDetail(Page page) {
        Document document = page.getHtml().getDocument();

        //house code
        String contentInfo = document.select("meta[name=mobile-agent]").attr("content");
        int begin = contentInfo.lastIndexOf('/');
        int end = contentInfo.lastIndexOf('.');
        String codeStr = contentInfo.substring(begin + 1, end);
        page.putField(LianjiaFieldInfo.HOUSE_CODE, codeStr);

        //价格
        String priceInfo = document.select(".info .price").outerHtml().replaceAll("\n", "").replaceAll(" ", "");
        Matcher matcher = pricePattern.matcher(priceInfo);
        if (matcher.find()) {
            BigDecimal finalPrice = new BigDecimal(matcher.group(1));
            page.putField(LianjiaFieldInfo.FINAL_PRICE, finalPrice.multiply(new BigDecimal(10000)).longValue());
            page.putField(LianjiaFieldInfo.FINAL_UNIT_PRICE, new BigDecimal(matcher.group(1)).longValue());
        }

        //其他信息
        String msgInfo = document.select(".msg").outerHtml().replaceAll("\n", "").replaceAll(" ", "");
        matcher = msgPattern.matcher(msgInfo);
        if (matcher.find()) {
            BigDecimal oriPrice = new BigDecimal(matcher.group(1));
            page.putField(LianjiaFieldInfo.ORIGIN_PRICE, oriPrice.multiply(new BigDecimal(10000)).longValue());
            String dealTimeStr = matcher.group(2);
            page.putField(LianjiaFieldInfo.DEAL_TIME,
                    NumberUtils.isDigits(dealTimeStr) ? Integer.valueOf(dealTimeStr) : -1);
            String adjStr = matcher.group(3);
            page.putField(LianjiaFieldInfo.ADJUST_COUNT, NumberUtils.isDigits(adjStr) ? Integer.valueOf(adjStr) : -1);
            String lookStr = matcher.group(4);
            page.putField(LianjiaFieldInfo.LOOK_COUNT, NumberUtils.isDigits(lookStr) ? Integer.valueOf(lookStr) : -1);
            String attStr = matcher.group(5);
            page.putField(LianjiaFieldInfo.ATTENTION_COUNT,
                    NumberUtils.isDigits(attStr) ? Integer.valueOf(attStr) : -1);
        }

    }

    private void processUnknownPage(Page page) {
        LOGGER.warn("未知页面: {}", page.getUrl());
        page.setSkip(true);
    }

    private void processListPage(Page page) {
        Document document = page.getHtml().getDocument();

        Integer number = Integer.valueOf(document.select(".resultDes span").text().trim());

        if (number > 3000) {
            //按照行政区域划分，房源过多，则按照地区查找
            Element areaList = document.select("[data-role='ershoufang']").get(0);
            for (Element element : areaList.child(1).children()) {
                String href = element.attr("href");
                if (href == null || href.length() == 0) {
                    continue;
                }
                String suffixUrl = href.substring(href.indexOf('/', 1) + 1);

                page.addTargetRequest(shDealCityRoot + suffixUrl);
                page.setSkip(true);
            }
        } else {
            Elements houseList = document.select(".info .title a");
            for (Element house : houseList) {
                String houseHref = house.attr("href");
                page.addTargetRequest(houseHref);
            }
            page.setSkip(true);

            Elements pageInfo = document.select(".house-lst-page-box");
            if (pageInfo != null && !pageInfo.isEmpty()) {

                Json pageJson = new Json(pageInfo.attr("page-data"));
                Integer totalPage = Integer.valueOf(pageJson.jsonPath("$.totalPage").get());
                Integer curPage = Integer.valueOf(pageJson.jsonPath("$.curPage").get());
                LOGGER.info("curPage: {}, totalPage: {}", curPage, totalPage);

                if (curPage < totalPage) {
                    if (curPage == 1) {
                        page.addTargetRequest(page.getUrl().get() + "pg2/");
                    } else {
                        String url = page.getUrl().get();
                        url = url.substring(0, url.length() - 1);
                        page.addTargetRequest(url.substring(0, url.lastIndexOf('/')) + "/pg" + (curPage + 1) + "/");
                    }
                }
            }

        }
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public void setShDealCityRoot(String secondHandCityRoot) {
        this.shDealCityRoot = secondHandCityRoot;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
