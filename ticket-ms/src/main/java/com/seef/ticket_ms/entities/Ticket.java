package com.seef.ticket_ms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    private String codeTicket;

    private Double prixTicket;

    @Enumerated(EnumType.STRING)
    private TypeTicket typeTicket;

    // Store the ID of the Evenement (foreign key in a microservice context)
    private Long idEvenement;

    // Store the ID of the Internaute (foreign key in a microservice context)
    private Long idInternaute;
}
