package com.seef.internaute_ms.services;

import com.seef.internaute_ms.entities.Internaute;
import com.seef.internaute_ms.repositories.InternauteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternauteService {

    private final InternauteRepository ticketRepository;

    public InternauteService(InternauteRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Internaute addInternaute(Internaute internaute){
        return ticketRepository.save(internaute);
    }

    public Internaute getInternauteById(int id){
        return ticketRepository.findById(id).orElse(null);
    }

    public List<Internaute> getAllInternautes(){
        return ticketRepository.findAll();
    }

    public void deleteInternaute(int id){
        ticketRepository.deleteById(id);
    }

    public Internaute updateInternaute(Internaute internaute){
        return ticketRepository.save(internaute);
    }

}
