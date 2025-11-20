package org.formation.proxibanque.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conseiller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @OneToMany(mappedBy = "conseiller", cascade = CascadeType.ALL)
    private List<Client> clients = new ArrayList<>();

    public Conseiller() {}

    public Conseiller(String nom, String prenom, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public Agence getAgence() { return agence; }
    public void setAgence(Agence agence) { this.agence = agence; }

    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }

    public void addClient(Client client) {
        if (clients.size() < 10) {
            clients.add(client);
            client.setConseiller(this);
        } else {
            throw new IllegalStateException("Un conseiller ne peut avoir plus de 10 clients");
        }
    }
}