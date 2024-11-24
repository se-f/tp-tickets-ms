package com.seef.evenement_ms.controllers;

import com.seef.evenement_ms.entities.Categorie;
import com.seef.evenement_ms.services.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping()
    public Categorie addCategorie(@RequestBody Categorie categorie){
        return categorieService.ajouterCategorie(categorie);
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable int id){
        return categorieService.getCategorieById(id);
    }

    @GetMapping()
    public List<Categorie> getAllCategories(){
        return categorieService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable int id){
        categorieService.deleteCategorie(id);
    }

    @PutMapping()
    public Categorie updateCategorie(@RequestBody Categorie categorie){
        return categorieService.updateCategorie(categorie);
    }



}
