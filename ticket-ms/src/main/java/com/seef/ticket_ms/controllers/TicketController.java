package com.seef.ticket_ms.controllers;

import com.seef.ticket_ms.entities.Ticket;
import com.seef.ticket_ms.entities.TypeTicket;
import com.seef.ticket_ms.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping()
    public Ticket ajouterTicket(@RequestBody Ticket ticket) {
        return ticketService.ajouterTicket(ticket);
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable int id) {
        return ticketService.getTicketById(id);
    }

    @GetMapping()
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable int id) {
        ticketService.deleteTicket(id);
    }

    @PutMapping()
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    @PostMapping("/ajouterTicketsEtAffecterAEvenementEtInternaute")
    public List<?> ajouterTicketsEtAffecterAEvenementEtInternaute(@RequestBody List<Ticket> tickets, @RequestParam Long idEvenement, @RequestParam Long idInternaute) {
        return ticketService.ajouterTicketsEtAffecterAEvenementEtInternaute(tickets, idEvenement, idInternaute);
    }

    @GetMapping("/montant")
    public Double getMontantParEvtEtTypeTicket(@RequestParam String nomEvt, @RequestParam TypeTicket typeTicket) {
        return ticketService.montantRecupereParEvtEtTypeTicket(nomEvt, typeTicket);
    }

    @GetMapping("/internauteLePlusActif")
    public String internauteLePlusActif() {
        return ticketService.internauteLePlusActif();
    }

}
