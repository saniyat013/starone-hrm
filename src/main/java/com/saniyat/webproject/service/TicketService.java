package com.saniyat.webproject.service;


import com.saniyat.webproject.entity.ticket.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();

    Ticket findById(int theId);

    Ticket save(Ticket theTicket);

    void deleteById(int theId);
}
