package com.babyjuan.house.task.spider;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import us.codecraft.webmagic.Spider.Status;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/9 13:56
 * @Description:
 */
public class JsonTest {

    @Test
    public void enumTest() {
        Status status = Status.Running;
        System.out.println(status);
        System.out.println(JSON.toJSON(status));
        System.out.println(JSON.toJSONString(status));
    }
}
