package com.babyjuan.house.service.crawler.impl.webmagic;

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

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 16:18
 * @Description:
 */
public class LianjiaPageProcessor implements PageProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LianjiaPageProcessor.class);

    private Site site;

    private String cityRentRoot;
    private String city;


    private Pattern rentAreaPattern = Pattern.compile("<span><i class=\"area\"></i>([\\d\\.]+)?㎡.*?</span>");
    private Pattern typePattern = Pattern.compile("<span><i class=\"typ\"></i>(\\d+)?室(\\d+)?厅.+</span>");
    private Pattern orientationPattern = Pattern.compile("<span><i class=\"orient\"></i>(.*)?</span>");
    private Pattern initPattern = Pattern.compile(".*?require\\(\\['detail/zufang'\\],function\\(init\\)\\{"
            + "init\\((.+)?\\);"
            + "}\\);.*?");
    private Pattern locationPattern = Pattern
            .compile("<p><i>位置：</i><a href=\".+?\">(.+?)</a> <a href=\".+?\">(.+?)</a></p>");
    private Pattern communityPattern = Pattern
            .compile("&nbsp; <a href=\".+?\">(.+?)租房</a>.*?<a href=\".+?\">(.+?)租房</a>"
                    + "&nbsp;&gt;&nbsp; </p>\n<h1> <a href=\"/zufang/c(.+?)/\">(.+?)租房</a> </h1>");

    public LianjiaPageProcessor(int sleepTime, int retryTimes) {
        this.site = Site.me().setRetryTimes(retryTimes).setSleepTime(sleepTime).setDisableCookieManagement(true);
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

        String hc = document.select(".contact_name").attr("data-houseCode");
        page.putField(LianjiaFieldInfo.HOUSE_CODE, hc);

        page.putField(LianjiaFieldInfo.TITLE, document.select(".content__title").text());

        String houseContent = document.select(".content__article__table").html();

        Matcher matcher = rentAreaPattern.matcher(houseContent);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.RENT_AREA, matcher.group(1));
        }
        matcher = typePattern.matcher(houseContent);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.BED_ROOM_NUM, matcher.group(1));
            page.putField(LianjiaFieldInfo.HALL_NUM, matcher.group(2));
        }
        matcher = orientationPattern.matcher(houseContent);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.ORIENTATION, matcher.group(1));
        }
        page.putField(LianjiaFieldInfo.PRICE_TOTAL, document.select(".content__aside--title span").text());

        String communityContent = document.select(".bread__nav").html();
        matcher = communityPattern.matcher(communityContent);
        if (matcher.find()) {
            page.putField(LianjiaFieldInfo.DISTRICT, matcher.group(1));
            page.putField(LianjiaFieldInfo.BLOCK, matcher.group(2));
            page.putField(LianjiaFieldInfo.CITY, city);
            page.putField(LianjiaFieldInfo.COMMUNITY_CODE, matcher.group(3));
            page.putField(LianjiaFieldInfo.COMMUNITY_NAME, matcher.group(4));
        }


      /*  Elements scripts = document.select("script");
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
        }*/
    }

    private void processUnknownPage(Page page) {
        LOGGER.warn("未知页面: {}", page.getUrl());
        page.setSkip(true);
    }

    private void processSearchPage(Page page) {
        Document document = page.getHtml().getDocument();

        Integer number = Integer.valueOf(document.select(".content__title--hl").text());
        String head = document.select(".bread__nav h1 a").text();

        LOGGER.info("{} : 共{}套房源", head, number);

        if (number > 3000) {
            //按照行政区域划分，房源过多，则按照地区查找
            Elements areaList = document.select(".filter__item--level3 a");
            for (int i = 1; i < areaList.size(); i++) {
                Element area = areaList.get(i);
                String href = area.attr("href");
                String suffixUrl = href.substring(href.indexOf('/', 1) + 1);

                page.addTargetRequest(cityRentRoot + suffixUrl);
                page.setSkip(true);
            }
        } else {
            Elements houseList = document.select(".content__list--item--aside");
            for (Element house : houseList) {
                String houseHref = house.attr("href");
                page.addTargetRequest(houseHref);
                page.setSkip(true);
            }

            Elements pageInfo = document.select(".content__pg");
            if (pageInfo != null && !pageInfo.isEmpty()) {
                Integer totalPage = Integer.valueOf(pageInfo.attr("data-totalPage"));
                Integer curPage = Integer.valueOf(pageInfo.attr("data-curPage"));
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

    public void setCityRentRoot(String cityRentRoot) {
        this.cityRentRoot = cityRentRoot;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
