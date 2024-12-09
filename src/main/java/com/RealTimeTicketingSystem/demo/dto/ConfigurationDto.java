package com.RealTimeTicketingSystem.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConfigurationDto {
    @Min(value = 1, message = "Max ticket capacity must be at least 1")
    @Max(value = 100, message = "Max ticket capacity cannot exceed 100")
    private int maxTicketCapacity;

    @Min(value = 1, message = "Total ticket capacity must be at least 1")
    @Max(value = 100, message = "Total ticket capacity cannot exceed 100")
    private int totalTicketCapacity;

    @Min(value = 100, message = "Ticket release rate must be at least 100 ms")
    @Max(value = 10000, message = "Ticket release rate cannot exceed 10000 ms")
    private long ticketReleaseRate;

    @Min(value = 100, message = "Ticket retrieval rate must be at least 100 ms")
    @Max(value = 10000, message = "Ticket retrieval rate cannot exceed 10000 ms")
    private long ticketRetrievalRate;
}