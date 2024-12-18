package com.seef.evenement_ms.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
public class EvenementDTO {
    private long idEvenement;
    private String nomEvenement;
    private long nbPlacesRestants;
    private LocalDate dateEvenement;
    private Set<Long> categories;
}

