package com.anasdev.gestiondelivraisonservice.controller;
import com.anasdev.gestiondelivraisonservice.model.Livraison;
import com.anasdev.gestiondelivraisonservice.service.LivraisonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livraisons")
public class LivraisonController {

    private final LivraisonService livraisonService;

    @Autowired
    public LivraisonController(LivraisonService livraisonService) {
        this.livraisonService = livraisonService;
    }

    // Create a new Livraison
    @PostMapping
    public ResponseEntity<Livraison> createLivraison(@Valid @RequestBody Livraison livraison) {
        Livraison createdLivraison = livraisonService.createLivraison(livraison);
        return new ResponseEntity<>(createdLivraison, HttpStatus.CREATED);
    }

    // Get a Livraison by ID
    @GetMapping("/{id}")
    public ResponseEntity<Livraison> getLivraisonById(@PathVariable Long id) {
        Optional<Livraison> livraison = livraisonService.getLivraisonById(id);
        return livraison.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get all Livraisons
    @GetMapping
    public List<Livraison> getAllLivraisons() {
        return livraisonService.getAllLivraisons();
    }

    // Update a Livraison
    @PutMapping("/{id}")
    public ResponseEntity<Livraison> updateLivraison(@PathVariable Long id, @Valid @RequestBody Livraison livraison) {
        Livraison updatedLivraison = livraisonService.updateLivraison(id, livraison);
        return updatedLivraison != null ? ResponseEntity.ok(updatedLivraison) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a Livraison
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivraison(@PathVariable Long id) {
        boolean isDeleted = livraisonService.deleteLivraison(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
