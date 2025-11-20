package org.formation.proxibanque.model;

import jakarta.persistence.Entity;

@Entity
public class CompteEpargne extends Compte {
    private double tauxRemuneration = 3.0;

    public CompteEpargne() {}

    public CompteEpargne(String numeroCompte, double solde) {
        super(numeroCompte, solde);
    }

    public CompteEpargne(String numeroCompte, double solde, double tauxRemuneration) {
        super(numeroCompte, solde);
        this.tauxRemuneration = tauxRemuneration;
    }

    // Getters et Setters
    public double getTauxRemuneration() { return tauxRemuneration; }
    public void setTauxRemuneration(double tauxRemuneration) {
        this.tauxRemuneration = tauxRemuneration;
    }

    public void appliquerRemuneration() {
        double interet = this.getSolde() * (tauxRemuneration / 100);
        this.crediter(interet);
    }
}