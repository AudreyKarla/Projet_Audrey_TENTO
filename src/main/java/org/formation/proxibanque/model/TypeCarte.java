package org.formation.proxibanque.model;

public enum TypeCarte {
    VISA_ELECTRON("Visa Electron"),
    VISA_PREMIER("Visa Premier");

    private final String libelle;

    TypeCarte(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}