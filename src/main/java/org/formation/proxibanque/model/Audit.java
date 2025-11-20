package org.formation.proxibanque.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateAudit;

    @ManyToOne
    private Agence agence;

    private boolean auditReussi;

    @ElementCollection
    private List<String> anomalies = new ArrayList<>();

    public Audit() {
        this.dateAudit = LocalDateTime.now();
    }

    public Audit(Agence agence) {
        this();
        this.agence = agence;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDateAudit() { return dateAudit; }
    public void setDateAudit(LocalDateTime dateAudit) { this.dateAudit = dateAudit; }

    public Agence getAgence() { return agence; }
    public void setAgence(Agence agence) { this.agence = agence; }

    public boolean isAuditReussi() { return auditReussi; }
    public void setAuditReussi(boolean auditReussi) { this.auditReussi = auditReussi; }

    public List<String> getAnomalies() { return anomalies; }
    public void setAnomalies(List<String> anomalies) { this.anomalies = anomalies; }

    public void ajouterAnomalie(String anomalie) {
        this.anomalies.add(anomalie);
    }
}