package com.seef.ticket_ms.interfaces;

import com.seef.ticket_ms.dto.InternauteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "internaute-service", url = "http://localhost:8082") // L'URL doit être correcte pour votre service
public interface InternauteClient {

    @GetMapping("/api/internautes/{idInternaute}")
    InternauteDTO getInternaute(@PathVariable("idInternaute") Long idInternaute);

    @GetMapping("/api/internautes/identifiant/{id}")
    String getInternauteIdentifiantById(@PathVariable("id") String identifiant);
}