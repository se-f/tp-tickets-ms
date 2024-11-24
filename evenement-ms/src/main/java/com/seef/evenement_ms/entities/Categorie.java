package com.seef.evenement_ms.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idCategorie;
    public String codeCategorie;
    public String nomCategorie;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private Set<Evenement> evenements = new HashSet<>();
}
