package com.RealTimeTicketingSystem.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "system_configuration")
public class SystemConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int maxTicketCapacity;

    @Column(nullable = false)
    private int totalTicketCapacity;

    @Column(nullable = false)
    private long ticketReleaseRate;

    @Column(nullable = false)
    private long ticketRetrievalRate;
}