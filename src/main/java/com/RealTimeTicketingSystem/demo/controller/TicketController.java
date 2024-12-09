package com.RealTimeTicketingSystem.demo.controller;

import com.RealTimeTicketingSystem.demo.service.TicketService;
import com.RealTimeTicketingSystem.demo.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.createTicket(ticketDto));
    }

    @GetMapping("/available")
    public ResponseEntity<List<TicketDto>> getAvailableTickets() {
        return ResponseEntity.ok(ticketService.getAvailableTickets());
    }

    @PostMapping("/purchase/{ticketId}")
    public ResponseEntity<TicketDto> purchaseTicket(@PathVariable String ticketId) {
        return ResponseEntity.ok(ticketService.purchaseTicket(ticketId));
    }
}