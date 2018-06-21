package com.babyjuan.house.service.crawler.webmagic;

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
public class LianjiaPageProcessor implements PageProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LianjiaPageProcessor.class);

    private Site site;

    private String LIANJIA_CITY_RENT_ROOT;
    private String CITY;


    private Pattern rentAreaPattern = Pattern.compile("<p class=\"lf\"><i>面积：</i>([\\d\\.]+)?平米.*?</p>");
    private Pattern typePattern = Pattern.compile("<p class=\"lf\"><i>房屋户型：</i>(\\d+)?室(\\d+)?厅.+</p>");
    private Pattern orientationPattern = Pattern.compile("<p class=\"lf\"><i>房屋朝向：</i>(.*)?</p>");
    private Pattern initPattern = Pattern.compile(".*?require\\(\\['detail/zufang'\\],function\\(init\\)\\{"
            + "init\\((.+)?\\);"
            + "}\\);.*?");
    private Pattern locationPattern = Pattern
            .compile("<p><i>位置：</i><a href=\".+?\">(.+?)</a> <a href=\".+?\">(.+?)</a></p>");

    public LianjiaPageProcessor(int sleepTime, int retryTimes) {
        this.site = Site.me().setRetryTimes(retryTimes).setSleepTime(sleepTime);
    }

    @Override
    public void process(Page page) {
        String url = page.getUrl().toString();
        if (url.contains("zufang") && url.endsWith(".html")) {
            //房屋信息详情页面，包括收集小区相关信息
            processHouseDetail(page);
        } else if (url.contains("zufang")) {
            //分类检索页面
            processSearchPage(page);
        } else {
            //无关页面
            processUnknownPage(page);
        }
    }

    private void processHouseDetail(Page page) {
        Document document = page.getHtml().getDocument();
        page.putField(LianjiaFieldInfo.TITLE, document.select(".title-wrapper h1").text());

        String content = document.select(".zf-room").html();
        Matcher matcher = rentAreaPattern.matcher(content);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.RENT_AREA, matcher.group(1));
        }
        matcher = typePattern.matcher(content);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.BED_ROOM_NUM, matcher.group(1));
            page.putField(LianjiaFieldInfo.HALL_NUM, matcher.group(2));
        }
        matcher = orientationPattern.matcher(content);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.ORIENTATION, matcher.group(1));
        }
        matcher = locationPattern.matcher(content);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.DISTRICT, matcher.group(1));
            page.putField(LianjiaFieldInfo.BLOCK, matcher.group(2));
            page.putField(LianjiaFieldInfo.CITY, CITY);
        }

        page.putField(LianjiaFieldInfo.PRICE_TOTAL, document.select(".zf-content .total").text());

        Elements scripts = document.select("script");
        for (Element script : scripts) {
            LOGGER.debug("script html: {}", script.html());
            if (script.html().contains("['detail/zufang']")) {
                matcher = initPattern.matcher(script.html().replace("\n", "").replace(" ", ""));
                if (matcher.find()) {
                    Json json = new Json(matcher.group(1));
                    page.putField(LianjiaFieldInfo.HOUSE_CODE, json.jsonPath("$.houseId").get());
                    page.putField(LianjiaFieldInfo.COMMUNITY_CODE, json.jsonPath("$.resblockId").get());
                    page.putField(LianjiaFieldInfo.COMMUNITY_NAME, json.jsonPath("$.resblockName").get());
                    String[] location = json.jsonPath("$.resblockPosition").get().split(",");
                    page.putField(LianjiaFieldInfo.LONGITUDE, location[0]);
                    page.putField(LianjiaFieldInfo.LATITUDE, location[1]);
                }
            }
        }
    }

    private void processUnknownPage(Page page) {
        LOGGER.warn("未知页面: {}", page.getUrl());
        page.setSkip(true);
    }

    private void processSearchPage(Page page) {
        Document document = page.getHtml().getDocument();

        Integer number = Integer.valueOf(document.select(".con-box h2 span").text());
        String head = document.select(".index_h1").text();

        LOGGER.info("{} : 共{}套房源", head, number);

        if (number > 3000) {
            //按照行政区域划分，房源过多，则按照地区查找
            Elements areaList = document.select("#filter-options .sub-option-list a");
            for (int i = 1; i < areaList.size(); i++) {
                Element area = areaList.get(i);
                String href = area.attr("href");
                String suffixUrl = href.substring(href.indexOf('/', 1) + 1);

                page.addTargetRequest(LIANJIA_CITY_RENT_ROOT + suffixUrl);
                page.setSkip(true);
            }
        } else {
            Elements houseList = document.select("#house-lst li");
            for (Element house : houseList) {
                String houseHref = house.select(".pic-panel a").attr("href");
                page.addTargetRequest(houseHref);
                page.setSkip(true);
            }

            String pageInfo = document.select(".house-lst-page-box").attr("page-data");
            if (pageInfo != null && !pageInfo.isEmpty()) {
                Json json = new Json(pageInfo);
                Integer curPage = Integer.valueOf(json.jsonPath("$.curPage").get());
                Integer totalPage = Integer.valueOf(json.jsonPath("$.totalPage").get());
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

    public void setLIANJIA_CITY_RENT_ROOT(String LIANJIA_CITY_RENT_ROOT) {
        this.LIANJIA_CITY_RENT_ROOT = LIANJIA_CITY_RENT_ROOT;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }
}
