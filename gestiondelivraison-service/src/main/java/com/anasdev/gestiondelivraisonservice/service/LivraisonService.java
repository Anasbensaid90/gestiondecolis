package com.anasdev.gestiondelivraisonservice.service;

import com.anasdev.gestiondelivraisonservice.model.Livraison;
import com.anasdev.gestiondelivraisonservice.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LivraisonService {

    private final LivraisonRepository livraisonRepository;

    @Autowired
    public LivraisonService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    public Livraison createLivraison(Livraison livraison) {
        livraison.setCreatedAt(new Date());  // Use current date and time
        livraison.setUpdatedAt(new Date());  // Use current date and time
        return livraisonRepository.save(livraison);
    }

    public Optional<Livraison> getLivraisonById(Long id) {
        return livraisonRepository.findById(id);
    }

    public List<Livraison> getAllLivraisons() {
        return livraisonRepository.findAll();
    }

    public Livraison updateLivraison(Long id, Livraison updatedLivraison) {
        Optional<Livraison> existingLivraison = livraisonRepository.findById(id);
        if (existingLivraison.isPresent()) {
            Livraison livraison = existingLivraison.get();
            livraison.setDestination(updatedLivraison.getDestination());
            livraison.setStatus(updatedLivraison.getStatus());
            livraison.setUpdatedAt(new Date());  // Update to current date and time
            return livraisonRepository.save(livraison);
        }
        return null;  // Or throw exception if not found
    }

    public boolean deleteLivraison(Long id) {
        if (livraisonRepository.existsById(id)) {
            livraisonRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
