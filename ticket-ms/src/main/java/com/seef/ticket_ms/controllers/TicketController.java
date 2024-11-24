package com.seef.ticket_ms.controllers;

import com.seef.ticket_ms.entities.Ticket;
import com.seef.ticket_ms.entities.TypeTicket;
import com.seef.ticket_ms.services.TicketService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
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


    @RateLimiter(name = "myRateLimiter", fallbackMethod = "fallbackAjout")
    @CircuitBreaker(name = "product-microservice", fallbackMethod = "fallbackAjout")
    @Retry(name = "myRetry", fallbackMethod = "fallbackAjout")
    @PostMapping("/ajouterTicketsEtAffecterAEvenementEtInternaute")
    public List<?> ajouterTicketsEtAffecterAEvenementEtInternaute(@RequestBody List<Ticket> tickets, @RequestParam Long idEvenement, @RequestParam Long idInternaute) {
        return ticketService.ajouterTicketsEtAffecterAEvenementEtInternaute(tickets, idEvenement, idInternaute);
    }


    @RateLimiter(name = "myRateLimiter", fallbackMethod = "fallbackMontant")
    @CircuitBreaker(name = "product-microservice", fallbackMethod = "fallbackMontant")
    @Retry(name = "myRetry", fallbackMethod = "fallbackMontant")
    @GetMapping("/montant")
    public Double getMontantParEvtEtTypeTicket(@RequestParam String nomEvt, @RequestParam TypeTicket typeTicket) {
        return ticketService.montantRecupereParEvtEtTypeTicket(nomEvt, typeTicket);
    }


    @RateLimiter(name = "myRateLimiter", fallbackMethod = "fallback")
    @CircuitBreaker(name = "product-microservice", fallbackMethod = "fallback")
    @Retry(name = "myRetry", fallbackMethod = "fallback")
    @GetMapping("/internauteLePlusActif")
    public String internauteLePlusActif() {
        return ticketService.internauteLePlusActif();
    }

    public String fallback(Throwable throwable) {
        return "Fallback: Service is temporarily unavailable. " + throwable.getMessage();
    }

    public Double fallbackMontant(Throwable throwable) {
        return -1.0;
    }

    public List<?> fallbackAjout(Throwable throwable) {
        System.err.println("Fallback: Service is temporarily unavailable. " + throwable.getMessage());
        return null;
    }

}
