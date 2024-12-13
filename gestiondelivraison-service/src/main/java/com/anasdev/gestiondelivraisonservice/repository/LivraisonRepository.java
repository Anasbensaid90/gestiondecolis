package com.anasdev.gestiondelivraisonservice.repository;

import com.anasdev.gestiondelivraisonservice.model.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
}
