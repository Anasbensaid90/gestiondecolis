package com.anasdev.gestiondelivraisonservice.service;

import com.anasdev.gestiondelivraisonservice.model.Livraison;
import com.anasdev.gestiondelivraisonservice.repository.LivraisonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivraisonService {

    private final LivraisonRepository livraisonRepository;

    public LivraisonService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    public List<Livraison> getAllLivraisons() {
        return livraisonRepository.findAll();
    }

    public Optional<Livraison> getLivraisonById(Long id) {
        return livraisonRepository.findById(id);
    }

    public Livraison saveLivraison(Livraison livraison) {
        return livraisonRepository.save(livraison);
    }

    public void deleteLivraison(Long id) {
        livraisonRepository.deleteById(id);
    }
}
