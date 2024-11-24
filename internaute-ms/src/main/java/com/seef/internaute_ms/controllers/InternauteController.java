package com.seef.internaute_ms.controllers;

import com.seef.internaute_ms.entities.Internaute;
import com.seef.internaute_ms.services.InternauteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internautes")
public class InternauteController {

    private final InternauteService internauteService;

    public InternauteController(InternauteService internauteService) {
        this.internauteService = internauteService;
    }

    @PostMapping()
    public Internaute addInternaute(@RequestBody Internaute internaute) {
        return internauteService.addInternaute(internaute);
    }

    @GetMapping("/{id}")
    public Internaute getInternauteById(@PathVariable int id) {
        return internauteService.getInternauteById(id);
    }

    @GetMapping()
    public List<Internaute> getAllInternautes() {
        return internauteService.getAllInternautes();
    }

    @DeleteMapping("/{id}")
    public void deleteInternaute(@PathVariable int id) {
        internauteService.deleteInternaute(id);
    }

    @PutMapping()
    public Internaute updateInternaute(@RequestBody Internaute internaute) {
        return internauteService.updateInternaute(internaute);
    }

    @GetMapping("/identifiant/{id}")
    public String getInternauteIdentifiantById(@PathVariable String id) {
        return internauteService.getInternauteIdentifiantById(id);
    }

}
