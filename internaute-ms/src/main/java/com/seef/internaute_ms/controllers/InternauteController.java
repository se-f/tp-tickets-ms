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

    @PostMapping("")
    public Internaute addTicket(@RequestBody Internaute internaute){
        return internauteService.addInternaute(internaute);
    }

    @GetMapping("/{id}")
    public Internaute getTicketById(@PathVariable int id){
        return internauteService.getInternauteById(id);
    }

    @GetMapping("/get")
    public List<Internaute> getAllTickets(){
        return internauteService.getAllInternautes();
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable int id){
        internauteService.deleteInternaute(id);
    }

    @PutMapping()
    public Internaute updateTicket(@RequestBody Internaute internaute){
        return internauteService.updateInternaute(internaute);
    }

}
