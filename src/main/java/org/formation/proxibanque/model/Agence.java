package org.formation.proxibanque.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Agence {
    @Id
    private String idAgence;

    private LocalDate dateCreation;

    @OneToOne
    private Conseiller gerant;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private List<Conseiller> conseillers = new ArrayList<>();

    public Agence() {}

    public Agence(String idAgence, LocalDate dateCreation) {
        this.idAgence = idAgence;
        this.dateCreation = dateCreation;
    }

    // Getters et Setters
    public String getIdAgence() { return idAgence; }
    public void setIdAgence(String idAgence) { this.idAgence = idAgence; }

    public LocalDate getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDate dateCreation) { this.dateCreation = dateCreation; }

    public Conseiller getGerant() { return gerant; }
    public void setGerant(Conseiller gerant) { this.gerant = gerant; }

    public List<Conseiller> getConseillers() { return conseillers; }
    public void setConseillers(List<Conseiller> conseillers) { this.conseillers = conseillers; }

    public void addConseiller(Conseiller conseiller) {
        conseillers.add(conseiller);
        conseiller.setAgence(this);
    }
}