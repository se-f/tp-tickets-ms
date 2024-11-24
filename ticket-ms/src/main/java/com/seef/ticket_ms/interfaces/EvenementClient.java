package com.seef.ticket_ms.interfaces;

import com.seef.ticket_ms.dto.EvenementDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "evenement-service", url = "http://localhost:8083")
public interface EvenementClient {

    @GetMapping("/api/evenements/{idEvenement}")
    EvenementDTO getEvenement(@PathVariable("idEvenement") Long idEvenement);

    @PutMapping("/api/evenements")
    EvenementDTO updateEvenement(@RequestBody EvenementDTO evenementDTO);

    @GetMapping("/api/evenements/by-nom/{nom}")
    EvenementDTO getEvenementByNom(@RequestParam("nom") String nom);
}
