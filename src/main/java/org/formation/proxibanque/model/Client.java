package org.formation.proxibanque.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;
    private String email;

    private boolean clientFortune = false;

    @ManyToOne
    @JoinColumn(name = "conseiller_id")
    private Conseiller conseiller;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compte> comptes = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarteBancaire> cartes = new ArrayList<>();

    public Client() {}

    public Client(String nom, String prenom, String adresse, String codePostal,
                  String ville, String telephone, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isClientFortune() { return clientFortune; }
    public void setClientFortune(boolean clientFortune) { this.clientFortune = clientFortune; }

    public Conseiller getConseiller() { return conseiller; }
    public void setConseiller(Conseiller conseiller) { this.conseiller = conseiller; }

    public List<Compte> getComptes() { return comptes; }
    public void setComptes(List<Compte> comptes) { this.comptes = comptes; }

    public List<CarteBancaire> getCartes() { return cartes; }
    public void setCartes(List<CarteBancaire> cartes) { this.cartes = cartes; }

    public void addCompte(Compte compte) {
        comptes.add(compte);
        compte.setClient(this);
    }

    public void addCarte(CarteBancaire carte) {
        cartes.add(carte);
        carte.setClient(this);
    }

    public double getSoldeTotal() {
        return comptes.stream().mapToDouble(Compte::getSolde).sum();
    }
}