package com.babyjuan.house.service.pusher.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/21 11:22
 * @Description:
 */
@Configuration
@EnableWebSocket
public class MyWebSocketConfig implements WebSocketConfigurer {

    private String webSocketUrl = "/websocket/socketServer.do";
    private String sockjs_url = "/sockjs/socketServer.do";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //1.注册WebSocket
        registry.addHandler(webSocketHandler(), webSocketUrl);
        //2.注册SockJS，提供SockJS支持(主要是兼容ie8)
        registry.addHandler(webSocketHandler(), sockjs_url).
                withSockJS();
    }

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new MyWebSocketHandler();
    }
}
