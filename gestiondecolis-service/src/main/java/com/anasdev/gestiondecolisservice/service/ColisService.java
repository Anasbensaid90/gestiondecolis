package com.anasdev.gestiondecolisservice.service;

import com.anasdev.gestiondecolisservice.model.Colis;
import com.anasdev.gestiondecolisservice.repository.ColisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColisService {

    @Autowired
    private ColisRepository colisRepository;

    // Récupérer tous les colis
    public List<Colis> getAllColis() {
        return colisRepository.findAll();
    }

    // Récupérer un colis par ID
    public Optional<Colis> getColisById(Long id) {
        return colisRepository.findById(id);
    }

    // Enregistrer un colis (ajouter un nouveau colis)
    public Colis saveColis(Colis colis) {
        return colisRepository.save(colis);
    }

    // Supprimer un colis
    public void deleteColis(Long id) {
        colisRepository.deleteById(id);
    }

    public Colis mettreAJourColis(Long id, Colis colisMiseAJour) {
        Optional<Colis> colisExistantOpt = colisRepository.findById(id);

        if (colisExistantOpt.isPresent()) {
            Colis colisExistant = colisExistantOpt.get();

            // Met à jour uniquement les champs présents
            if (colisMiseAJour.getDescription() != null) {
                colisExistant.setDescription(colisMiseAJour.getDescription());
            }
            if (colisMiseAJour.getPoids() != 0) {
                colisExistant.setPoids(colisMiseAJour.getPoids());
            }
            if (colisMiseAJour.getDimensions() != null) {
                colisExistant.setDimensions(colisMiseAJour.getDimensions());
            }
            if (colisMiseAJour.getEtat() != null) {
                colisExistant.setEtat(colisMiseAJour.getEtat());
            }

            // **Ne pas écraser les adresses si elles ne sont pas spécifiées**
            if (colisMiseAJour.getAdresseExpediteur() != null) {
                colisExistant.setAdresseExpediteur(colisMiseAJour.getAdresseExpediteur());
            }
            if (colisMiseAJour.getAdresseDestinataire() != null) {
                colisExistant.setAdresseDestinataire(colisMiseAJour.getAdresseDestinataire());
            }

            return colisRepository.save(colisExistant);
        } else {
            return null;
        }

    }

}
