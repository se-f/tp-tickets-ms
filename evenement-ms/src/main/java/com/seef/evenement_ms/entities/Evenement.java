package com.seef.evenement_ms.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEvenement;

    private String nomEvenement;
    private long nbPlacesRestants;

    private LocalDate dateEvenement;

    @ManyToMany
    @JoinTable(
            name = "evenement_categorie",
            joinColumns = @JoinColumn(name = "id_evenement"),
            inverseJoinColumns = @JoinColumn(name = "id_categorie")
    )
    @JsonManagedReference
    private Set<Categorie> categories;


}
