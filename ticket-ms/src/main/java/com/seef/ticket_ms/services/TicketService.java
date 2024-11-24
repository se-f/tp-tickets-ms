package com.seef.ticket_ms.services;

import com.seef.ticket_ms.entities.Ticket;
import com.seef.ticket_ms.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket ajouterTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(int id){
        return ticketRepository.findById(id).orElse(null);
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public void deleteTicket(int id){
        ticketRepository.deleteById(id);
    }

    public Ticket updateTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

}
