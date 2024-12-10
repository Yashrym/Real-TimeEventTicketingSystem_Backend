package com.RealTimeTicketingSystem.demo.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.RealTimeTicketingSystem.demo.model.Ticket.TicketStatus;

@Data
public class TicketDto {
    private String id;
    private String eventName;
    private BigDecimal price;
    private LocalDateTime eventTime;
    private String seatNumber;
    private TicketStatus status;
}