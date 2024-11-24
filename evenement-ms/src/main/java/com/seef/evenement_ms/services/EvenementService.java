package com.seef.evenement_ms.services;

import com.seef.evenement_ms.dto.EvenementDTO;
import com.seef.evenement_ms.entities.Categorie;
import com.seef.evenement_ms.entities.Evenement;
import com.seef.evenement_ms.mappers.EvenementMapper;
import com.seef.evenement_ms.repositories.CategorieRepository;
import com.seef.evenement_ms.repositories.EvenementRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EvenementService {

    private final EvenementRepository evenementRepository;
    private final EvenementMapper evenementMapper;

    public EvenementService(EvenementRepository evenementRepository, EvenementMapper evenementMapper) {
        this.evenementRepository = evenementRepository;
        this.evenementMapper = evenementMapper;
    }

    public Evenement ajouterEvenement(EvenementDTO evenementDTO) {
        Evenement evenement = evenementMapper.toEntity(evenementDTO);
        return evenementRepository.save(evenement);
    }

    public Evenement getEvenementById(int id) {
        return evenementRepository.findById(id).orElse(null);
    }

    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    public void deleteEvenement(int id) {
        evenementRepository.deleteById(id);
    }

    public Evenement updateEvenement(EvenementDTO evenementDTO) {
        Evenement evenement = evenementMapper.toEntity(evenementDTO);
        return evenementRepository.save(evenement);
    }

    @Transactional
    @Scheduled(fixedRate = 15000)
    public void listeEvenementsParCategorie() {
        System.out.println("Liste des événements par catégorie");
        List<Evenement> evenements = getAllEvenements();

        evenements.forEach(evenement -> {
            Set<Categorie> categories = evenement.getCategories(); // Assuming Evenement has a Set of categories
            categories.forEach(categorie -> System.out.println("Catégorie: " + categorie.getNomCategorie() + ", Evenement: " + evenement.getNomEvenement()));
        });
    }


}
