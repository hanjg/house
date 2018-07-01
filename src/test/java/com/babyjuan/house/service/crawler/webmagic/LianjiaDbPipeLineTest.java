package com.babyjuan.house.service.crawler.webmagic;

import com.babyjuan.house.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/22 22:57
 * @Description:
 */
public class LianjiaDbPipeLineTest extends BaseTest {

    @Autowired
    private Pipeline pipeLine;

    @Test
    public void process() throws Exception {
        pipeLine.process(getResultItems(), Spider.create(new LianjiaPageProcessor(1, 1)));
        Thread.sleep(2 * 1000);
        pipeLine.process(getResultItems().put(LianjiaFieldInfo.TITLE, "精装两房交通便利 采光好 看房方便，价格优美"),
                Spider.create(new LianjiaPageProcessor(1, 1)));
        Thread.sleep(2 * 1000);
        pipeLine.process(getResultItems().put(LianjiaFieldInfo.TITLE, "精装两房交通便利 采光好 看房方便，价格优美"),
                Spider.create(new LianjiaPageProcessor(1, 1)));
        Thread.sleep(2 * 1000);
        pipeLine.process(getResultItems().put(LianjiaFieldInfo.TITLE, "精装两房交通便利 采光好 看房方便，价格优美"),
                Spider.create(new LianjiaPageProcessor(1, 1)));
    }

    private ResultItems getResultItems() {
        ResultItems resultItems = new ResultItems();
        resultItems.put(LianjiaFieldInfo.HOUSE_CODE, "103102512869");
        resultItems.put(LianjiaFieldInfo.TITLE, "壹城西区 3室2厅 2500元");
        resultItems.put(LianjiaFieldInfo.BED_ROOM_NUM, "3");
        resultItems.put(LianjiaFieldInfo.HALL_NUM, "2");
        resultItems.put(LianjiaFieldInfo.ORIENTATION, "南 北");
        resultItems.put(LianjiaFieldInfo.PRICE_TOTAL, "2500");
        resultItems.put(LianjiaFieldInfo.RENT_AREA, "70");
        resultItems.put(LianjiaFieldInfo.COMMUNITY_CODE, "1111111");
        resultItems.put(LianjiaFieldInfo.COMMUNITY_NAME, "123");
        resultItems.put(LianjiaFieldInfo.LATITUDE, "111.11");
        resultItems.put(LianjiaFieldInfo.LONGITUDE, "111.11");
        resultItems.put(LianjiaFieldInfo.CITY, "1111111");
        resultItems.put(LianjiaFieldInfo.DISTRICT, "1111111");
        resultItems.put(LianjiaFieldInfo.BLOCK, "1111111");
        return resultItems;
    }

}