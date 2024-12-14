package com.anasdev.gestiondelivraisonservice.controller;

import com.anasdev.gestiondelivraisonservice.model.EtatLivraison;
import com.anasdev.gestiondelivraisonservice.model.Livraison;
import com.anasdev.gestiondelivraisonservice.service.LivraisonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livraisons")
public class LivraisonController {

    private final LivraisonService livraisonService;

    public LivraisonController(LivraisonService livraisonService) {
        this.livraisonService = livraisonService;
    }

    @GetMapping
    public List<Livraison> getAllLivraisons() {
        return livraisonService.getAllLivraisons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livraison> getLivraisonById(@PathVariable Long id) {
        return livraisonService.getLivraisonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Livraison createLivraison(@RequestBody Livraison livraison) {
        livraison.setEtat(EtatLivraison.EN_ATTENTE); // Par défaut, livraison en attente
        return livraisonService.saveLivraison(livraison);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livraison> updateLivraison(@PathVariable Long id, @RequestBody Livraison updatedLivraison) {
        return livraisonService.getLivraisonById(id)
                .map(existingLivraison -> {
                    existingLivraison.setCodeLivraison(updatedLivraison.getCodeLivraison());
                    existingLivraison.setColis(updatedLivraison.getColis());
                    existingLivraison.setLivreur(updatedLivraison.getLivreur());
                    existingLivraison.setEtat(updatedLivraison.getEtat());
                    return ResponseEntity.ok(livraisonService.saveLivraison(existingLivraison));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivraison(@PathVariable Long id) {
        if (livraisonService.getLivraisonById(id).isPresent()) {
            livraisonService.deleteLivraison(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
