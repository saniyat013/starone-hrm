package com.saniyat.webproject.rest;

import com.saniyat.webproject.entity.ticket.Ticket;
import com.saniyat.webproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketRestController {
    private TicketService ticketService;

    @Autowired
    public TicketRestController(TicketService theTicketService) {
        ticketService = theTicketService;
    }

    @GetMapping("/tickets")
    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    @GetMapping("/tickets/{ticketId}")
    public Ticket getTicket(@PathVariable int ticketId) {
        Ticket theTicket = ticketService.findById(ticketId);

        if (theTicket == null) {
            throw new RuntimeException("Ticket id not found - " + ticketId);
        }

        return theTicket;
    }

    @PostMapping("/tickets")
    public Ticket addTicket(@RequestBody Ticket theTicket) {
        theTicket.setId(0);
        Ticket dbTicket = ticketService.save(theTicket);
        return dbTicket;
    }

    @PutMapping("/tickets")
    public Ticket updateTicket(@RequestBody Ticket theTicket) {
        Ticket dbTicket = ticketService.save(theTicket);
        return dbTicket;
    }

    @DeleteMapping("tickets/{ticketId}")
    public String deleteTicket(@PathVariable int ticketId) {
        Ticket tempTicket = ticketService.findById(ticketId);
        if (tempTicket == null) {
            throw new RuntimeException("Ticket id not found - " + ticketId);
        }
        ticketService.deleteById(ticketId);
        return "Deleted ticket with id - " + ticketId;
    }
}
