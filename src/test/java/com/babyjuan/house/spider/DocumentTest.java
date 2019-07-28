package com.babyjuan.house.spider;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/10 19:04
 * @Description:
 */
public class DocumentTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentTest.class);

    @Test
    public void getDoc() throws IOException {
        String url = "http://www.xicidaili.com/wn/1";
        Document document = Jsoup.connect(url).timeout(5 * 1000).get();
        Elements trs = document.getElementsByTag("tr");
        if (trs != null && trs.size() > 1) {
            for (int i = 1; i < trs.size(); i++) {
                Elements tds = trs.get(i).getElementsByTag("td");
                System.out.println(tds.get(1).text() + ":" + tds.get(2).text());
            }
        }
    }
}
