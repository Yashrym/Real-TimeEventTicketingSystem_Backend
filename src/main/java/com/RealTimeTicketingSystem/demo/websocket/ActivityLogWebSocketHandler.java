package com.RealTimeTicketingSystem.demo.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class ActivityLogWebSocketHandler extends TextWebSocketHandler {

    private final Set<WebSocketSession> sessions = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Add the new session to the list of active sessions
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) throws Exception {
        // Remove the session when it is closed
        sessions.remove(session);
    }

    public void sendLogUpdate(String logMessage) {
        // Broadcast the log message to all active WebSocket sessions
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(logMessage));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
