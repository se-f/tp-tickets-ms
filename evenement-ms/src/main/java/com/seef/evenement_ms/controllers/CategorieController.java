package com.seef.evenement_ms.controllers;

import com.seef.evenement_ms.dto.CategorieDTO;
import com.seef.evenement_ms.entities.Categorie;
import com.seef.evenement_ms.services.CategorieService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CategorieDTO> addCategorie(@RequestBody CategorieDTO categorie){
        categorieService.ajouterCategorie(categorie);
        return ResponseEntity.ok(categorie);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable int id){
        categorieService.getCategorieById(id);
        return ResponseEntity.ok().build();
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
    public CategorieDTO updateCategorie(@RequestBody CategorieDTO categorie){
        categorieService.updateCategorie(categorie);
        return categorie;
    }



}
