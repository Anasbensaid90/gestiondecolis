package com.anasdev.servicedesuividelivraisonsservice.repository;
import com.anasdev.servicedesuividelivraisonsservice.model.Suivi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuiviRepository extends JpaRepository<Suivi, Long> {
    List<Suivi> findByLivraisonId(Long livraisonId);  // Fetch tracking updates for a specific delivery
}
