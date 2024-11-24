package com.seef.evenement_ms.controllers;

import com.seef.evenement_ms.dto.EvenementDTO;
import com.seef.evenement_ms.entities.Evenement;
import com.seef.evenement_ms.services.EvenementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evenements")
public class EvenementController {

    private final EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @PostMapping()
    public Evenement addEvenement(@RequestBody EvenementDTO evenement) {
        return evenementService.ajouterEvenement(evenement);
    }

    @GetMapping("/{id}")
    public Evenement getEvenementById(@PathVariable int id) {
        return evenementService.getEvenementById(id);
    }

    @GetMapping()
    public List<Evenement> getAllEvenements() {
        return evenementService.getAllEvenements();
    }

    @DeleteMapping("/{id}")
    public void deleteEvenement(@PathVariable int id) {
        evenementService.deleteEvenement(id);
    }

    @PutMapping()
    public Evenement updateEvenement(@RequestBody EvenementDTO evenement) {
        return evenementService.updateEvenement(evenement);
    }

    @GetMapping("/by-nom/{nom}")
    public Evenement getEvenementByNom(@RequestParam String nom) {
        return evenementService.getEvenementByNom(nom);
    }

}
