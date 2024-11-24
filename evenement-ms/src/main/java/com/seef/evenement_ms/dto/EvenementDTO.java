package com.seef.evenement_ms.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class EvenementDTO {
    private String nomEvenement;
    private long nbPlacesRestants;
    private LocalDate dateEvenement;
    private Set<Long> categories;
}

