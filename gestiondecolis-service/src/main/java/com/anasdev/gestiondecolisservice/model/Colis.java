package com.anasdev.gestiondecolisservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Colis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private double poids;

    private String dimensions;

    private String adresseExpediteur;

    private String adresseDestinataire;

    @Enumerated(EnumType.STRING)
    private EtatColis etat;

    @ElementCollection
    @CollectionTable(name = "historique_colis", joinColumns = @JoinColumn(name = "colis_id"))
    @Column(name = "statut")
    private List<String> historiqueStatuts = new ArrayList<>();

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPoids() { return poids; }
    public void setPoids(double poids) { this.poids = poids; }

    public String getDimensions() { return dimensions; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }

    public String getAdresseExpediteur() { return adresseExpediteur; }
    public void setAdresseExpediteur(String adresseExpediteur) { this.adresseExpediteur = adresseExpediteur; }

    public String getAdresseDestinataire() { return adresseDestinataire; }
    public void setAdresseDestinataire(String adresseDestinataire) { this.adresseDestinataire = adresseDestinataire; }

    public EtatColis getEtat() { return etat; }
    public void setEtat(EtatColis etat) {
        this.etat = etat;
        historiqueStatuts.add(etat.name() + " - " + LocalDateTime.now().toString());
    }

    public List<String> getHistoriqueStatuts() { return historiqueStatuts; }
}
