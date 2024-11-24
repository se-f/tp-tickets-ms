package com.seef.internaute_ms.repositories;

import com.seef.internaute_ms.entities.Internaute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternauteRepository extends JpaRepository<Internaute, Integer> {
}
