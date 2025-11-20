package org.formation.proxibanque.model;

import jakarta.persistence.Entity;

@Entity
public class CompteCourant extends Compte {
    private double decouvertAutorise = 1000.0;

    public CompteCourant() {}

    public CompteCourant(String numeroCompte, double solde) {
        super(numeroCompte, solde);
    }

    public CompteCourant(String numeroCompte, double solde, double decouvertAutorise) {
        super(numeroCompte, solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    // Getters et Setters
    public double getDecouvertAutorise() { return decouvertAutorise; }
    public void setDecouvertAutorise(double decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public boolean debiter(double montant) {
        if (this.getSolde() + this.decouvertAutorise >= montant) {
            this.setSolde(this.getSolde() - montant);
            return true;
        }
        return false;
    }
}