package com.RealTimeTicketingSystem.demo.repository;

import com.RealTimeTicketingSystem.demo.model.SystemConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemConfigurationRepository extends JpaRepository<SystemConfiguration, Long> {
    SystemConfiguration findTopByOrderByIdDesc();
}