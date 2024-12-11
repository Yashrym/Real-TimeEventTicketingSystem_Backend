package com.RealTimeTicketingSystem.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.RealTimeTicketingSystem.demo.model.ActivityLog;
import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("/api/logs")
public class LogController {
    @GetMapping("/get")
    public String getLogs() {
        return "Logs";
    }
    public ResponseEntity<List<ActivityLog>> getActivityLogs() {
        // Implement the logic to fetch the activity logs
        List<ActivityLog> logs = new ArrayList<>();
        // Add log entries to the logs list
        ActivityLog log1 = new ActivityLog();
        log1.setMessage("Log 1");
        logs.add(log1);
        ActivityLog log2 = new ActivityLog();
        log2.setMessage("Log 2");
        logs.add(log2);

        return ResponseEntity.ok(logs);
    }

}
