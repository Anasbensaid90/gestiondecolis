package com.anasdev.servicedesuividelivraisonsservice.controller;
import com.anasdev.servicedesuividelivraisonsservice.model.Suivi;
import com.anasdev.servicedesuividelivraisonsservice.service.SuiviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suivi")
public class SuiviController {

    private final SuiviService suiviService;

    @Autowired
    public SuiviController(SuiviService suiviService) {
        this.suiviService = suiviService;
    }

    // Create or update tracking information
    @PostMapping
    public ResponseEntity<Suivi> createOrUpdateSuivi(@RequestBody Suivi suivi) {
        Suivi createdSuivi = suiviService.createOrUpdateSuivi(suivi);
        return ResponseEntity.ok(createdSuivi);
    }

    // Get tracking details for a specific delivery
    @GetMapping("/{livraisonId}")
    public ResponseEntity<List<Suivi>> getTracking(@PathVariable Long livraisonId) {
        List<Suivi> suivis = suiviService.getTrackingByLivraisonId(livraisonId);
        if (suivis.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(suivis);
    }
}
