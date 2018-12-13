package com.babyjuan.house.service.crawler;

import com.alibaba.fastjson.JSON;
import com.babyjuan.house.HouseApplicationTests;
import org.junit.Test;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.Spider.Status;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/9 13:56
 * @Description:
 */
public class JsonTest extends HouseApplicationTests {

    @Test
    public void enumTest() {
        Status status = Status.Running;
        System.out.println(status);
        System.out.println(JSON.toJSON(status));
        System.out.println(JSON.toJSONString(status));
    }
}
