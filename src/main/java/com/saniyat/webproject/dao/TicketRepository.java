package com.saniyat.webproject.dao;

import com.saniyat.webproject.entity.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
