package com.seef.internaute_ms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Internaute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInternaute;

    private long identifiant;
    private TrancheAge trancheAge;


}
