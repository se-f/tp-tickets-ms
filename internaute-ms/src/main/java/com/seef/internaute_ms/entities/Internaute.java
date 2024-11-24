package com.seef.internaute_ms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "internaute")
public class Internaute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInternaute;

    private String identifiant;

    @Enumerated(EnumType.STRING)
    private TrancheAge trancheAge;


}
