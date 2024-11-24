package com.seef.evenement_ms.repositories;

import com.seef.evenement_ms.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
    Evenement findByNomEvenement(String nom);
}
