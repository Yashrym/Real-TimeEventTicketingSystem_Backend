package com.RealTimeTicketingSystem.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.RealTimeTicketingSystem.demo.model.ActivityLog;
import com.RealTimeTicketingSystem.demo.websocket.ActivityLogWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private ActivityLogWebSocketHandler webSocketHandler;

    // Endpoint to get logs
    @GetMapping("/get")
    public String getLogs() {
        return "Logs";
    }

    // Example implementation for fetching activity logs
    @GetMapping
    public ResponseEntity<List<ActivityLog>> getActivityLogs() {
        // Fetch activity logs (this is a placeholder implementation)
        List<ActivityLog> logs = new ArrayList<>();
        ActivityLog log1 = new ActivityLog();
        log1.setMessage("Log 1");
        logs.add(log1);
        ActivityLog log2 = new ActivityLog();
        log2.setMessage("Log 2");
        logs.add(log2);

        return ResponseEntity.ok(logs);
    }

    // Endpoint to add logs and broadcast via WebSocket
    @PostMapping
    public void addLog(@RequestBody String logMessage) {
        // Log the message to the console (you can extend this to save it in a database)
        System.out.println("Received log: " + logMessage);

        // Broadcast the log to WebSocket clients
        webSocketHandler.sendLogUpdate(logMessage);
    }
}
