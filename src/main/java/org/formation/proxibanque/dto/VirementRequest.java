package org.formation.proxibanque.dto;

public class VirementRequest {
    private String compteSource;
    private String compteDestination;
    private double montant;
    private String description;

    public VirementRequest() {}

    public VirementRequest(String compteSource, String compteDestination, double montant, String description) {
        this.compteSource = compteSource;
        this.compteDestination = compteDestination;
        this.montant = montant;
        this.description = description;
    }

    // Getters et Setters
    public String getCompteSource() { return compteSource; }
    public void setCompteSource(String compteSource) { this.compteSource = compteSource; }

    public String getCompteDestination() { return compteDestination; }
    public void setCompteDestination(String compteDestination) { this.compteDestination = compteDestination; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}