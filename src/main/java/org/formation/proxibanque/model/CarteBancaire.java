package org.formation.proxibanque.model;

import jakarta.persistence.*;

@Entity
public class CarteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCarte;
    private boolean active = true;

    @Enumerated(EnumType.STRING)
    private TypeCarte typeCarte;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    public CarteBancaire() {}

    public CarteBancaire(String numeroCarte, TypeCarte typeCarte, Compte compte) {
        this.numeroCarte = numeroCarte;
        this.typeCarte = typeCarte;
        this.compte = compte;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroCarte() { return numeroCarte; }
    public void setNumeroCarte(String numeroCarte) { this.numeroCarte = numeroCarte; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public TypeCarte getTypeCarte() { return typeCarte; }
    public void setTypeCarte(TypeCarte typeCarte) { this.typeCarte = typeCarte; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Compte getCompte() { return compte; }
    public void setCompte(Compte compte) { this.compte = compte; }

    public void desactiver() {
        this.active = false;
    }
}