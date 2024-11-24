package com.seef.ticket_ms.repositories;

import com.seef.ticket_ms.entities.Ticket;
import com.seef.ticket_ms.entities.TypeTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByIdEvenementAndTypeTicket(long idEvenement, TypeTicket typeTicket);
}
