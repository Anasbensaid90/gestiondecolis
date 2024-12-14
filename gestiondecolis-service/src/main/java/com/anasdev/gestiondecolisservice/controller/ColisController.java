package com.anasdev.gestiondecolisservice.controller;

import com.anasdev.gestiondecolisservice.model.Colis;
import com.anasdev.gestiondecolisservice.model.EtatColis;
import com.anasdev.gestiondecolisservice.service.ColisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colis")
public class ColisController {

    private final ColisService colisService;

    public ColisController(ColisService colisService) {
        this.colisService = colisService;
    }

    @GetMapping
    public List<Colis> getAllColis() {
        return colisService.getAllColis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colis> getColisById(@PathVariable Long id) {
        return colisService.getColisById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Colis createColis(@RequestBody Colis colis) {
        colis.setEtat(EtatColis.PREPARE); // Par défaut, un colis est prêt
        return colisService.saveColis(colis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colis> updateColis(@PathVariable Long id, @RequestBody Colis updatedColis) {
        return colisService.getColisById(id)
                .map(existingColis -> {
                    existingColis.setDescription(updatedColis.getDescription());
                    existingColis.setPoids(updatedColis.getPoids());
                    existingColis.setDimensions(updatedColis.getDimensions());
                    existingColis.setAdresseExpediteur(updatedColis.getAdresseExpediteur());
                    existingColis.setAdresseDestinataire(updatedColis.getAdresseDestinataire());
                    existingColis.setEtat(updatedColis.getEtat());
                    return ResponseEntity.ok(colisService.saveColis(existingColis));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColis(@PathVariable Long id) {
        if (colisService.getColisById(id).isPresent()) {
            colisService.deleteColis(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
