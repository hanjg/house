package com.babyjuan.house.service.crawler;

import com.alibaba.fastjson.JSON;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.junit.Test;
import us.codecraft.webmagic.selector.Json;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 22:34
 * @Description:
 */
public class PatternTest {

    private Pattern rentAreaPattern = Pattern.compile("<p class=\"lf\"><i>面积：</i>(.+)?平米</p>");
    private Pattern typePattern = Pattern.compile("<p class=\"lf\"><i>房屋户型：</i>(\\d+)?室(\\d+)?厅.+</p>");
    private Pattern orientationPattern = Pattern.compile("<p class=\"lf\"><i>房屋朝向：</i>(.*)?</p>");
    private Pattern initPattern = Pattern.compile(".*?require\\(\\['detail/zufang'\\],function\\(init\\)\\{"
            + "init\\((.+)?\\);"
            + "}\\);.*?");
    private Pattern locationPattern = Pattern
            .compile("<p><i>位置：</i><a href=\".+?\">(.+?)</a> <a href=\".+?\">(.+?)</a></p>");


    @Test
    public void regex() {
        String html = "<p class=\"lf\"><i>面积：</i>70.18平米</p>";
        Matcher matcher = rentAreaPattern.matcher(html);
        matcher.find();
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
    }

    @Test
    public void area() {
        String content =" <p class=\"lf\"><i>面积：</i>70.18平米</p><p class=\"lf\"><i>房屋户型：</i>2室2厅1卫  </p>\n"
                + "      <p class=\"lf\"><i>楼层：</i>中楼层 (共7层)</p><p class=\"lf\"><i>房屋朝向：</i>南 北</p>\n"
                + "      <div class=\"clear\"></div>\n"
                + "            <p><i>地铁：</i>距地铁4号线龙江234米</p>\n"
                + "            <p><i>小区：</i><a href=\"https://nj.lianjia.com/xiaoqu/1411000000500/\">宁工新寓二村</a>\n"
                + "            - <a href=\"https://nj.lianjia.com/zufang/c1411000000500/\">13套出租中</a></p>\n"
                + "            <p><i>位置：</i><a href=\"https://nj.lianjia.com/zufang/gulou/\">鼓楼</a> <a href=\"https://nj.lianjia.com/zufang/caochangmendajie/\">草场门大街</a></p>\n"
                + "      <p class=\"lf\"><i>时间：</i>20天前发布</p>      <div class=\"clear\"></div>";
        System.out.println("content: " + content);

        Matcher matcher = rentAreaPattern.matcher(content);
        matcher.find();
        System.out.println("area: " + matcher.group(1));

        matcher = typePattern.matcher(content);
        matcher.find();
        System.out.println("type: " + matcher.group(1) + " " + matcher.group(2));

        matcher = orientationPattern.matcher(content);
        matcher.find();
        System.out.println("orientation: " + matcher.group(1));

        matcher = locationPattern.matcher(content);
        matcher.find();
        System.out.println("location: " + matcher.group(1) + " " + matcher.group(2));
    }

    @Test
    public void testJson() {
        String content = "require(['detail/zufang'], function (init) {\n"
                + "    init({\n"
                + "      isLoged: 0,\n"
                + "      area: '70.18平米',\n"
                + "      totalPrice: '3500',\n"
                + "      houseId: '103102421235',\n"
                + "      resblockId: '1411000000500',\n"
                + "      resblockName: '宁工新寓二村',\n"
                + "      isRemove: 0,\n"
                + "      defaultImg: 'https://s1.ljcdn.com/feroot/pc/asset/img/new-version/default_block.png?_v=2018060111280254',\n"
                + "      defaultBrokerIcon: 'https://s1.ljcdn.com/feroot/pc/asset/img/jingjiren/noimg.jpg?_v=2018060111280254',\n"
                + "      resblockPosition: '118.74379692436,32.065144281185',\n"
                + "      cityId: '320100'\n"
                + "    });\n"
                + "  });";
        content = content.replace("\n", "").replace(" ", "");
        System.out.println(content);
        System.out.println(initPattern.pattern());
        Matcher matcher = initPattern.matcher(content);
        matcher.find();
        Json json = new Json(matcher.group(1));

        System.out.println(json.jsonPath("$.area"));
    }
}
