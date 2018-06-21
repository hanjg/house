package com.babyjuan.house.service.pusher.websocket;

import com.babyjuan.house.common.utils.JsonUtils;
import com.babyjuan.house.dao.entity.RentingHouse;
import com.babyjuan.house.service.crawler.CrawlerService;
import com.babyjuan.house.service.crawler.model.SpiderState;
import com.babyjuan.house.service.manager.RentingHouseService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/21 11:27
 * @Description:
 */
public class MyWebSocketHandler extends TextWebSocketHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(MyWebSocketHandler.class);

    @Autowired
    private CrawlerService crawlerService;
    @Autowired
    private RentingHouseService rentingHouseService;

    @Value("${pusher.communities}")
    private String PUSHER_COMMUNITIES;
    @Value("${lianjia.city.rent.root}")
    private String LIANJIA_CITY_RENT_ROOT;

    private Date lastPushTime = DateTime.parse("1000-01-01").toDate();

    /**
     * 处理前端发送的文本信息 js调用websocket.send时候，会调用该方法
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        LOGGER.info("websocket handle text message: {}", message);
    }

    /**
     * 当新连接建立的时候，被调用 连接成功时候，会触发页面上onOpen方法
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("websocket connection established......");
        List<RentingHouse> houseList = new ArrayList<>();
        for (String communityName : PUSHER_COMMUNITIES.split(",")) {
            houseList.addAll(rentingHouseService.getLatestRelativeHouseList(communityName, lastPushTime));
        }
        SpiderState spiderState = crawlerService.status();
        String crawlerMessage =
                "爬虫状态: " + spiderState.getStatus() + "\n总页数: " + spiderState.getPageCount() + "\n开始时间: " + spiderState
                        .getStartTime();
        StringBuilder houseMessage = new StringBuilder("更新数量: " + houseList.size());
        for (RentingHouse house : houseList) {
            houseMessage.append("\n").append(house.getTitle()).append("\t").append(LIANJIA_CITY_RENT_ROOT)
                    .append(house.getHouseCode()).append(".html");
        }
        session.sendMessage(new TextMessage(crawlerMessage));
        session.sendMessage(new TextMessage(houseMessage.toString()));
        //更新最近推送时间
        lastPushTime = new Date();
        LOGGER.info("last push time: {}", lastPushTime);
    }

    /**
     * 当连接关闭时被调用
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        LOGGER.info("websocket connection closed......");
    }

    /**
     * 传输错误时调用
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        LOGGER.error("websocket connection error, closed......");
    }

}
