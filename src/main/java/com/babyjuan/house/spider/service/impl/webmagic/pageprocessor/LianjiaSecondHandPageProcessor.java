package com.babyjuan.house.spider.service.impl.webmagic.pageprocessor;

import com.babyjuan.house.spider.service.impl.webmagic.LianjiaFieldInfo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class LianjiaSecondHandPageProcessor implements PageProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LianjiaSecondHandPageProcessor.class);
    private Site site;
    private String secondHandCityRoot;
    private String city;

    private Pattern areaPattern = Pattern.compile("建筑面积</span>(.*?)㎡</li>");
    private Pattern typePattern = Pattern.compile("房屋户型</span>(\\d+)?室(\\d+)?厅.*?</li>");
    private Pattern orientationPattern = Pattern.compile("房屋朝向</span>(.*?)</li>");
    private Pattern initPattern = Pattern
            .compile(".*?require\\(\\['ershoufang/sellDetail/detailV3'\\],function\\(init\\)\\{"
                    + "init\\((.+)?\\);"
                    + "}\\);.*?");
    private Pattern blockPattern = Pattern.compile(
            "<span class=\"info\"><a href=\".+?\" target=\"_blank\">(.+)?</a>&nbsp;"
                    + "<a href=\".+?\" target=\"_blank\">(.+)?</a>&nbsp;.*?</span>");

    public LianjiaSecondHandPageProcessor(int sleepTime, int retryTimes) {
        this.site = Site.me().setRetryTimes(retryTimes).setSleepTime(sleepTime).setDisableCookieManagement(true);
    }

    @Override
    public void process(Page page) {
        String url = page.getUrl().toString();
        if (url.contains("ershoufang") && url.endsWith(".html")) {
            //房屋信息详情页面，包括收集小区相关信息
            processHouseDetail(page);
        } else if (url.contains("ershoufang")) {
            //分类检索页面
            processSearchPage(page);
        } else {
            //无关页面
            processUnknownPage(page);
        }
    }

    private void processHouseDetail(Page page) {
        Document document = page.getHtml().getDocument();

        //title
        page.putField(LianjiaFieldInfo.TITLE, document.select(".sellDetailHeader .main").attr("title"));

        //基本信息
        String houseBaseContent = document.select("#introduction .base").html();
        Matcher matcher = areaPattern.matcher(houseBaseContent);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.AREA, matcher.group(1));
        }
        matcher = typePattern.matcher(houseBaseContent);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.BED_ROOM_NUM, matcher.group(1));
            page.putField(LianjiaFieldInfo.HALL_NUM, matcher.group(2));
        }
        matcher = orientationPattern.matcher(houseBaseContent);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.ORIENTATION, matcher.group(1));
        }

        //初始化参数
        Elements scripts = document.select("script");
        for (Element script : scripts) {
            LOGGER.debug("script html: {}", script.html());
            if (script.html().contains("['ershoufang/sellDetail/detailV3']")) {
                matcher = initPattern.matcher(script.html().replace("\n", "").replace(" ", ""));
                if (matcher.find()) {
                    Json json = new Json(matcher.group(1));
                    page.putField(LianjiaFieldInfo.HOUSE_CODE, json.jsonPath("$.houseId").get());
                    page.putField(LianjiaFieldInfo.PRICE_TOTAL, json.jsonPath("$.totalPrice").get());
                    page.putField(LianjiaFieldInfo.UNIT_PRICE, json.jsonPath("$.price").get());
                    page.putField(LianjiaFieldInfo.HOUSE_TYPE, json.jsonPath("$.houseType").get());
                    page.putField(LianjiaFieldInfo.COMMUNITY_CODE, json.jsonPath("$.resblockId").get());
                    page.putField(LianjiaFieldInfo.COMMUNITY_NAME, json.jsonPath("$.resblockName").get());
                    String[] location = json.jsonPath("$.resblockPosition").get().split(",");
                    page.putField(LianjiaFieldInfo.LONGITUDE, location[0]);
                    page.putField(LianjiaFieldInfo.LATITUDE, location[1]);
                }
            }
        }

        //街区信息
        String blockContent = document.select(".areaName").html();
        matcher = blockPattern.matcher(blockContent);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.BLOCK, matcher.group(2));
            page.putField(LianjiaFieldInfo.DISTRICT, matcher.group(1));
            page.putField(LianjiaFieldInfo.CITY, city);
        }
    }

    private void processUnknownPage(Page page) {
        LOGGER.warn("未知页面: {}", page.getUrl());
        page.setSkip(true);
    }

    private void processSearchPage(Page page) {
        Document document = page.getHtml().getDocument();

        Integer number = Integer.valueOf(document.select(".resultDes span").text().trim());
        String head = document.select(".resultDes h2").text();
        LOGGER.info(head);

        if (number > 3000) {
            //按照行政区域划分，房源过多，则按照地区查找
            Element areaList = document.select("[data-role='ershoufang']").get(0);
            for (Element element : areaList.child(1).children()) {
                String href = element.attr("href");
                if (href == null || href.length() == 0) {
                    continue;
                }
                String suffixUrl = href.substring(href.indexOf('/', 1) + 1);

                page.addTargetRequest(secondHandCityRoot + suffixUrl);
                page.setSkip(true);
            }
        } else {
            Elements houseList = document.select(".bigImgList .item .title");
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

    public void setSecondHandCityRoot(String secondHandCityRoot) {
        this.secondHandCityRoot = secondHandCityRoot;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
