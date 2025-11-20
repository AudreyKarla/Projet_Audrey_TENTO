package org.formation.proxibanque.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCompte;
    private double solde;
    private LocalDate dateOuverture;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Compte() {
        this.dateOuverture = LocalDate.now();
    }

    public Compte(String numeroCompte, double solde) {
        this();
        this.numeroCompte = numeroCompte;
        this.solde = solde;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroCompte() { return numeroCompte; }
    public void setNumeroCompte(String numeroCompte) { this.numeroCompte = numeroCompte; }

    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }

    public LocalDate getDateOuverture() { return dateOuverture; }
    public void setDateOuverture(LocalDate dateOuverture) { this.dateOuverture = dateOuverture; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public void crediter(double montant) {
        this.solde += montant;
    }

    public boolean debiter(double montant) {
        if (this.solde >= montant) {
            this.solde -= montant;
            return true;
        }
        return false;
    }
}