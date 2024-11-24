package com.seef.evenement_ms.services;

import com.seef.evenement_ms.entities.Categorie;
import com.seef.evenement_ms.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public Categorie ajouterCategorie(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    public Categorie getCategorieById(int id){
        return categorieRepository.findById(id).orElse(null);
    }

    public List<Categorie> getAllCategories(){
        return categorieRepository.findAll();
    }

    public void deleteCategorie(int id){
        categorieRepository.deleteById(id);
    }

    public Categorie updateCategorie(Categorie categorie){
        return categorieRepository.save(categorie);
    }
}
