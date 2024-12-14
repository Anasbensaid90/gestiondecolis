package com.anasdev.gestiondecolisservice.repository;

import com.anasdev.gestiondecolisservice.model.Colis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColisRepository extends JpaRepository<Colis, Long> {
}
