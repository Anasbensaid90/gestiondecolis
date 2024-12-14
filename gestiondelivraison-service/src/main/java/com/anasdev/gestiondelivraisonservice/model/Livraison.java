package com.anasdev.gestiondelivraisonservice.model;
import com.anasdev.gestiondecolisservice.model.Colis;
import jakarta.persistence.*;
@Entity
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeLivraison; // Code unique pour identifier la livraison.

    @OneToOne
    @JoinColumn(name = "colis_id", referencedColumnName = "id")
    private Colis colis; // Association avec un colis.

    private String livreur; // Nom ou ID du livreur assigné.

    @Enumerated(EnumType.STRING)
    private EtatLivraison etat; // En attente, en cours, terminée.


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeLivraison() {
        return codeLivraison;
    }

    public void setCodeLivraison(String codeLivraison) {
        this.codeLivraison = codeLivraison;
    }

    public Colis getColis() {
        return colis;
    }

    public void setColis(Colis colis) {
        this.colis = colis;
    }

    public String getLivreur() {
        return livreur;
    }

    public void setLivreur(String livreur) {
        this.livreur = livreur;
    }

    public EtatLivraison getEtat() {
        return etat;
    }

    public void setEtat(EtatLivraison etat) {
        this.etat = etat;
    }
}
