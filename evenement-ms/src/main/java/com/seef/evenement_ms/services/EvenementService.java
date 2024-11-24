package com.seef.evenement_ms.services;

import com.seef.evenement_ms.entities.Categorie;
import com.seef.evenement_ms.entities.Evenement;
import com.seef.evenement_ms.repositories.EvenementRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EvenementService {

    private final EvenementRepository evenementRepository;

    public EvenementService(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    public Evenement ajouterEvenement(Evenement evenement){
        return evenementRepository.save(evenement);
    }

    public Evenement getEvenementById(int id){
        return evenementRepository.findById(id).orElse(null);
    }

    public List<Evenement> getAllEvenements(){
        return evenementRepository.findAll();
    }

    public void deleteEvenement(int id){
        evenementRepository.deleteById(id);
    }

    public Evenement updateEvenement(Evenement evenement){
        return evenementRepository.save(evenement);
    }

    @Scheduled(fixedRate = 15000)
    public void listeEvenementsParCategorie() {
        System.out.println("Liste des événements par catégorie");
        List<Evenement> evenements = getAllEvenements();

        evenements.forEach(evenement -> {
            Set<Categorie> categories = evenement.getCategories();
            categories.forEach(categorie -> System.out.println("Catégorie: " + categorie + ", Evenement: " + evenement.getNomEvenement()));
        });
    }

}
