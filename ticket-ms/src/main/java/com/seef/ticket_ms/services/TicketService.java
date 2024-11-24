package com.seef.ticket_ms.services;

import com.seef.ticket_ms.dto.EvenementDTO;
import com.seef.ticket_ms.dto.InternauteDTO;
import com.seef.ticket_ms.entities.Ticket;
import com.seef.ticket_ms.entities.TypeTicket;
import com.seef.ticket_ms.interfaces.EvenementClient;
import com.seef.ticket_ms.interfaces.InternauteClient;
import com.seef.ticket_ms.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final InternauteClient internauteClient;
    private final EvenementClient evenementClient;

    public TicketService(TicketRepository ticketRepository, InternauteClient internauteClient, EvenementClient evenementClient) {
        this.ticketRepository = ticketRepository;
        this.internauteClient = internauteClient;
        this.evenementClient = evenementClient;
    }

    public Ticket ajouterTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void deleteTicket(int id) {
        ticketRepository.deleteById(id);
    }

    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets, Long idEvenement, Long idInternaute) {

        EvenementDTO evenementDTO = evenementClient.getEvenement(idEvenement);

        System.err.println("evenementDTO = " + evenementDTO);

        if (evenementDTO == null) {
            throw new RuntimeException("Événement non trouvé");
        }

        long totalTicketsToAdd = tickets.size();
        if (evenementDTO.getNbPlacesRestants() < totalTicketsToAdd) {
            throw new UnsupportedOperationException("Nombre de places demandées indisponible");
        }

        // Récupérer l'internaute via OpenFeign et mapper vers InternauteDTO
        InternauteDTO internauteDTO = internauteClient.getInternaute(idInternaute);

        if (internauteDTO == null) {
            throw new RuntimeException("Internaute non trouvé");
        }

        // Affecter les tickets à l'internaute et à l'événement
        tickets.forEach(ticket -> ticket.setIdEvenement(evenementDTO.getIdEvenement()));
        tickets.forEach(ticket -> ticket.setIdInternaute(internauteDTO.getIdInternaute()));

        // Ajouter les tickets à la base de données
        List<Ticket> savedTickets = ticketRepository.saveAll(tickets);

        // Mettre à jour les places restantes de l'événement via Feign
        evenementDTO.setNbPlacesRestants(evenementDTO.getNbPlacesRestants() - totalTicketsToAdd);
        evenementClient.updateEvenement(evenementDTO);

        return savedTickets;
    }

    public Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket) {
        // Récupérer l'événement via le Feign client
        EvenementDTO evenementDTO = evenementClient.getEvenementByNom(nomEvt);

        if (evenementDTO == null) {
            throw new IllegalArgumentException("Événement introuvable pour le nom: " + nomEvt);
        }

        // Récupérer les tickets associés à cet événement et de ce type
        List<Ticket> tickets = ticketRepository.findByIdEvenementAndTypeTicket(evenementDTO.getIdEvenement(), typeTicket);

        // Calculer le montant à récupérer
        Double montantTotal = 0.0;
        for (Ticket ticket : tickets) {
            montantTotal += ticket.getPrixTicket();
        }

        return montantTotal;
    }

    public String internauteLePlusActif() {
        List<Object[]> result = ticketRepository.findInternauteWithMostTickets();

        if (result.isEmpty()) {
            return null;  // Aucun internaute trouvé
        }

        // Le premier élément du résultat correspond à l'internaute le plus actif
        String idInternaute = result.getFirst()[0].toString();  // L'ID de l'internaute
        System.err.println("idInternaute = " + idInternaute);
        return internauteClient.getInternauteIdentifiantById(idInternaute);  // Retourner le nom de l'internaute

    }

}
