package com.RealTimeTicketingSystem.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import com.RealTimeTicketingSystem.demo.websocket.ActivityLogWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final ActivityLogWebSocketHandler logWebSocketHandler;

    public WebSocketConfig(ActivityLogWebSocketHandler logWebSocketHandler) {
        this.logWebSocketHandler = logWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // Register the WebSocket handler and define the endpoint
        registry.addHandler(logWebSocketHandler, "/websocket/logs").setAllowedOrigins("*");
    }
}
