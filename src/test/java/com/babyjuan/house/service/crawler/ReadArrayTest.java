package com.babyjuan.house.service.crawler;

import com.babyjuan.house.base.BaseTest;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 17:51
 * @Description:
 */
public class ReadArrayTest extends BaseTest {

    @Value("${lianjia.root.urls}")
    private List<String> rootUrls;

    @Test
    public void read() {
        System.out.println("size: " + rootUrls.size());
        for (String url : rootUrls) {
            System.out.println(url);
        }
    }
}
