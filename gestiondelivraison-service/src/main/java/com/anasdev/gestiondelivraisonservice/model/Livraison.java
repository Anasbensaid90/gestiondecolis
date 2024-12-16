package com.anasdev.gestiondelivraisonservice.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long utilisateurId;

    private String depart;

    private String arrivee;

    private String flux;

    private Double poids;

    private BigDecimal prix;

    private String status;

    private Double latitude;   // Nouvelle latitude pour la position GPS
    private Double longitude;  // Nouvelle longitude pour la position GPS

    // Liste des identifiants des colis associés à cette livraison
    @ElementCollection
    @CollectionTable(name = "livraison_colis", joinColumns = @JoinColumn(name = "livraison_id"))
    @Column(name = "colis_id")
    private List<Long> colisIds = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public String getFlux() {
        return flux;
    }

    public void setFlux(String flux) {
        this.flux = flux;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<Long> getColisIds() {
        return colisIds;
    }

    public void setColisIds(List<Long> colisIds) {
        this.colisIds = colisIds;
    }
}