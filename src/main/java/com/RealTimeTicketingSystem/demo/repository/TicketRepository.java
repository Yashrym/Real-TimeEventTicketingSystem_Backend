package com.RealTimeTicketingSystem.demo.repository;

import com.RealTimeTicketingSystem.demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
    List<Ticket> findByStatus(Ticket.TicketStatus status);
    List<Ticket> findByEventName(String eventName);
}