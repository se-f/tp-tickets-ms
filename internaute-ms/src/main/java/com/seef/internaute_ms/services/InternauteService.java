package com.seef.internaute_ms.services;

import com.seef.internaute_ms.entities.Internaute;
import com.seef.internaute_ms.repositories.InternauteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternauteService {

    private final InternauteRepository ticketRepository;
    private final InternauteRepository internauteRepository;

    public InternauteService(InternauteRepository ticketRepository, InternauteRepository internauteRepository) {
        this.ticketRepository = ticketRepository;
        this.internauteRepository = internauteRepository;
    }

    public Internaute addInternaute(Internaute internaute) {
        return ticketRepository.save(internaute);
    }

    public Internaute getInternauteById(int id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public List<Internaute> getAllInternautes() {
        return ticketRepository.findAll();
    }

    public void deleteInternaute(int id) {
        ticketRepository.deleteById(id);
    }

    public Internaute updateInternaute(Internaute internaute) {
        return ticketRepository.save(internaute);
    }

    public String getInternauteIdentifiantById(String id) {
        Optional<Internaute> internaute = internauteRepository.findById(Integer.valueOf(id));
        return internaute.get().getIdentifiant();
    }
}
