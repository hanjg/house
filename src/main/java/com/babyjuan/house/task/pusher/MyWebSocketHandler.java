package com.babyjuan.house.task.pusher;

import com.babyjuan.house.common.constant.Constant;
import com.babyjuan.house.repository.entity.RentingHouse;
import com.babyjuan.house.service.CrawlerService;
import com.babyjuan.house.task.spider.config.LianjiaConst;
import com.babyjuan.house.task.spider.SpiderState;
import com.babyjuan.house.service.RentingHouseService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/21 11:27
 * @Description:
 */
public class MyWebSocketHandler extends AbstractWebSocketHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(MyWebSocketHandler.class);

    @Autowired
    @Qualifier("crawlerServiceImpl")
    private CrawlerService crawlerService;
    @Autowired
    private RentingHouseService rentingHouseService;

    @Autowired
    private PusherConst pusherConst;
    @Autowired
    private LianjiaConst lianjiaConst;

    private Date lastPushTime = Constant.LONG_LONG_AGO;

    /**
     * 处理前端发送的文本信息 js调用websocket.send时候，会调用该方法
     * 没有效果，原因？
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        LOGGER.info("websocket handle text message: {}", message);
        sendLatestNews(session);
    }

    /**
     * 当新连接建立的时候，被调用 连接成功时候，会触发页面上onOpen方法
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("websocket connection established......");
        sendLatestNews(session);
    }

    private void sendLatestNews(WebSocketSession session) throws IOException {
        List<RentingHouse> houseList = new ArrayList<>();
        for (String communityName : pusherConst.getPushedCommunities()) {
            houseList.addAll(rentingHouseService.getLatestFavourateHouseList(communityName, lastPushTime));
        }
        String crawlerMessage = getSpiderMessage();
        String houseMessage = getHouseMessage(houseList);
        session.sendMessage(new TextMessage(crawlerMessage + "\n\n" + houseMessage));
        //更新最近推送时间
        lastPushTime = new Date();
        LOGGER.info("last push time: {}", lastPushTime);
    }

    private String getHouseMessage(List<RentingHouse> houseList) {
        StringBuilder houseMessageBuilder = new StringBuilder("更新数量: " + houseList.size());
        for (RentingHouse house : houseList) {
            houseMessageBuilder.append("\n").append(house.getTitle()).append("\t")
                    .append(lianjiaConst.getRentCityRoot())
                    .append(house.getHouseCode()).append(".html");
        }
        return houseMessageBuilder.toString();
    }

    private String getSpiderMessage() {
        SpiderState spiderState = crawlerService.status();
        return "爬虫状态: " + spiderState.getStatus() + "\n总页数: " + spiderState.getPageCount() + "\n开始时间: " + spiderState
                .getStartTime();
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
