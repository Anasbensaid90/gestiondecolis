package com.anasdev.servicedesuividelivraisonsservice.service;
import com.anasdev.servicedesuividelivraisonsservice.model.Suivi;
import com.anasdev.servicedesuividelivraisonsservice.repository.SuiviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuiviService {

    private final SuiviRepository suiviRepository;

    @Autowired
    public SuiviService(SuiviRepository suiviRepository) {
        this.suiviRepository = suiviRepository;
    }

    // Create or update tracking information
    public Suivi createOrUpdateSuivi(Suivi suivi) {
        return suiviRepository.save(suivi);
    }

    // Get tracking details for a specific delivery
    public List<Suivi> getTrackingByLivraisonId(Long livraisonId) {
        return suiviRepository.findByLivraisonId(livraisonId);
    }
}
