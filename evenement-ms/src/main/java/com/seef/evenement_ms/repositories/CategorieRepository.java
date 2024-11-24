package com.seef.evenement_ms.repositories;

import com.seef.evenement_ms.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    List<Categorie> findAllById(Iterable<Integer> ids);
}
