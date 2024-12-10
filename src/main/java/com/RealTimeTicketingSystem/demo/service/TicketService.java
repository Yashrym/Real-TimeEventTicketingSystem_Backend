package com.RealTimeTicketingSystem.demo.service;

import com.RealTimeTicketingSystem.demo.model.Ticket;
import com.RealTimeTicketingSystem.demo.repository.TicketRepository;
import com.RealTimeTicketingSystem.demo.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Transactional
    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = convertToEntity(ticketDto);
        ticket.setStatus(Ticket.TicketStatus.AVAILABLE);
        Ticket savedTicket = ticketRepository.save(ticket);
        return convertToDto(savedTicket);
    }

    @Transactional(readOnly = true)
    public List<TicketDto> getAvailableTickets() {
        return ticketRepository.findByStatus(Ticket.TicketStatus.AVAILABLE)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TicketDto purchaseTicket(String ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (ticket.getStatus() != Ticket.TicketStatus.AVAILABLE) {
            throw new RuntimeException("Ticket is not available");
        }

        ticket.setStatus(Ticket.TicketStatus.SOLD);
        return convertToDto(ticketRepository.save(ticket));
    }

    // Conversion methods
    private Ticket convertToEntity(TicketDto dto) {
        Ticket ticket = new Ticket();
        ticket.setEventName(dto.getEventName());
        ticket.setPrice(dto.getPrice());
        ticket.setEventTime(dto.getEventTime());
        ticket.setSeatNumber(dto.getSeatNumber());
        return ticket;
    }

    private TicketDto convertToDto(Ticket ticket) {
        TicketDto dto = new TicketDto();
        dto.setId(ticket.getId());
        dto.setEventName(ticket.getEventName());
        dto.setPrice(ticket.getPrice());
        dto.setEventTime(ticket.getEventTime());
        dto.setSeatNumber(ticket.getSeatNumber());
        dto.setStatus(ticket.getStatus());
        return dto;
    }
}