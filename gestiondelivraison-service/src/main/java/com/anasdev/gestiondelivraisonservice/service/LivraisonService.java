package com.anasdev.gestiondelivraisonservice.service;

import com.anasdev.gestiondelivraisonservice.model.Livraison;
import com.anasdev.gestiondelivraisonservice.repository.LivraisonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivraisonService {

    private final LivraisonRepository livraisonRepository;

    public LivraisonService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    public List<Livraison> getAllLivraisons() {
        return livraisonRepository.findAll();
    }

    public Livraison getLivraisonById(Long id) {
        return livraisonRepository.findById(id).orElseThrow(() -> new RuntimeException("Livraison not found"));
    }

    public Livraison createLivraison(Livraison livraison) {
        return livraisonRepository.save(livraison);
    }

    public Livraison updateLivraison(Long id, Livraison updatedLivraison) {
        Livraison livraison = getLivraisonById(id);
        livraison.setUtilisateurId(updatedLivraison.getUtilisateurId());
        livraison.setDepart(updatedLivraison.getDepart());
        livraison.setArrivee(updatedLivraison.getArrivee());
        livraison.setFlux(updatedLivraison.getFlux());
        livraison.setPoids(updatedLivraison.getPoids());
        livraison.setPrix(updatedLivraison.getPrix());
        livraison.setStatus(updatedLivraison.getStatus());
        return livraisonRepository.save(livraison);
    }

    public void deleteLivraison(Long id) {
        livraisonRepository.deleteById(id);
    }
}