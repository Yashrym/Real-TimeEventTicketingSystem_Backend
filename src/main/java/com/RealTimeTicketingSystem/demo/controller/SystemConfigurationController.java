package com.RealTimeTicketingSystem.demo.controller;

import com.RealTimeTicketingSystem.demo.service.SystemConfigurationService;
import com.RealTimeTicketingSystem.demo.dto.ConfigurationDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/configuration")
public class SystemConfigurationController {
    @Autowired
    private SystemConfigurationService configService;

    @PutMapping("/save")
    public ResponseEntity<ConfigurationDto> saveConfiguration(
            @Valid @RequestBody ConfigurationDto configDto) {
        return ResponseEntity.ok(configService.saveConfiguration(configDto));
    }

    @GetMapping("/current")
    public ResponseEntity<ConfigurationDto> getCurrentConfiguration() {
        ConfigurationDto config = configService.getCurrentConfiguration();
        return config != null
                ? ResponseEntity.ok(config)
                : ResponseEntity.notFound().build();
    }
    @PostMapping("/start")
    public ResponseEntity<Void> startSystem() {
        configService.startSystem();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/stop")
    public ResponseEntity<Void> stopSystem() {
        configService.stopSystem();
        return ResponseEntity.ok().build();
    }
}