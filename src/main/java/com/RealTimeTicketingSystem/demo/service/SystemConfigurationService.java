package com.RealTimeTicketingSystem.demo.service;

import com.RealTimeTicketingSystem.demo.model.SystemConfiguration;
import com.RealTimeTicketingSystem.demo.repository.SystemConfigurationRepository;
import com.RealTimeTicketingSystem.demo.dto.ConfigurationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SystemConfigurationService {
    @Autowired
    private SystemConfigurationRepository configRepository;

    @Transactional
    public ConfigurationDto saveConfiguration(ConfigurationDto configDto) {
        SystemConfiguration config = convertToEntity(configDto);
        SystemConfiguration savedConfig = configRepository.save(config);
        return convertToDto(savedConfig);
    }

    @Transactional(readOnly = true)
    public ConfigurationDto getCurrentConfiguration() {
        SystemConfiguration config = configRepository.findTopByOrderByIdDesc();
        return config != null ? convertToDto(config) : null;
    }
    

    // Conversion methods
    private SystemConfiguration convertToEntity(ConfigurationDto dto) {
        SystemConfiguration config = new SystemConfiguration();
        config.setMaxTicketCapacity(dto.getMaxTicketCapacity());
        config.setTotalTicketCapacity(dto.getTotalTicketCapacity());
        config.setTicketReleaseRate(dto.getTicketReleaseRate());
        config.setTicketRetrievalRate(dto.getTicketRetrievalRate());
        return config;
    }

    private ConfigurationDto convertToDto(SystemConfiguration config) {
        ConfigurationDto dto = new ConfigurationDto();
        dto.setMaxTicketCapacity(config.getMaxTicketCapacity());
        dto.setTotalTicketCapacity(config.getTotalTicketCapacity());
        dto.setTicketReleaseRate(config.getTicketReleaseRate());
        dto.setTicketRetrievalRate(config.getTicketRetrievalRate());
        return dto;
    }
    @Transactional
    public void startSystem() {
        SystemConfiguration config = configRepository.findTopByOrderByIdDesc();
        if (config == null) {
            config = new SystemConfiguration();
            config.setMaxTicketCapacity(100);
            config.setTotalTicketCapacity(100);
            config.setTicketReleaseRate(10);
            config.setTicketRetrievalRate(10);
        }
    }
    @Transactional
    public void stopSystem() {
        configRepository.deleteAll();
    }
}