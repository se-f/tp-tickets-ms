package com.seef.ticket_ms.repositories;

import com.seef.ticket_ms.entities.Ticket;
import com.seef.ticket_ms.entities.TypeTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByIdEvenementAndTypeTicket(long idEvenement, TypeTicket typeTicket);

    // Trouver l'internaute ayant acheté le plus de tickets
    @Query("SELECT t.idInternaute, COUNT(t) FROM Ticket t GROUP BY t.idInternaute ORDER BY COUNT(t) DESC")
    List<Object[]> findInternauteWithMostTickets();
}
