package com.seef.evenement_ms.mappers;

import com.seef.evenement_ms.dto.EvenementDTO;
import com.seef.evenement_ms.entities.Categorie;
import com.seef.evenement_ms.entities.Evenement;
import com.seef.evenement_ms.repositories.CategorieRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EvenementMapper {

    private final CategorieRepository categorieRepository;

    // Injecter le repository si nécessaire pour récupérer les catégories
    public EvenementMapper(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    // Convertir EvenementDTO en Evenement
    public Evenement toEntity(EvenementDTO evenementDTO) {
        Evenement evenement = new Evenement();
        evenement.setNomEvenement(evenementDTO.getNomEvenement());
        evenement.setNbPlacesRestants(evenementDTO.getNbPlacesRestants());
        evenement.setDateEvenement(evenementDTO.getDateEvenement());

        // Récupérer les catégories à partir des IDs
        Set<Integer> categoryIds = evenementDTO.getCategories()
                .stream()
                .map(Long::intValue) // Conversion Long -> Integer
                .collect(Collectors.toSet());

        // Récupérer et convertir les catégories en Set
        Set<Categorie> categories = new HashSet<>(categorieRepository.findAllById(categoryIds));
        evenement.setCategories(categories);

        return evenement;
    }


    // Convertir Evenement en EvenementDTO
    public EvenementDTO toDTO(Evenement evenement) {
        EvenementDTO evenementDTO = new EvenementDTO();
        evenementDTO.setNomEvenement(evenement.getNomEvenement());
        evenementDTO.setNbPlacesRestants(evenement.getNbPlacesRestants());
        evenementDTO.setDateEvenement(evenement.getDateEvenement());

        // Extraire les IDs des catégories
        Set<Long> categoryIds = evenement.getCategories()
                .stream()
                .map(Categorie::getIdCategorie)
                .collect(Collectors.toSet());
        evenementDTO.setCategories(categoryIds);

        return evenementDTO;
    }
}
