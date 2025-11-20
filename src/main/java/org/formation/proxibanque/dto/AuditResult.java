package org.formation.proxibanque.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AuditResult {
    private Long auditId;
    private String agenceId;
    private LocalDateTime dateAudit;
    private boolean auditReussi;
    private List<String> anomalies;
    private int nombreAnomalies;

    public AuditResult() {}

    // Getters et Setters
    public Long getAuditId() { return auditId; }
    public void setAuditId(Long auditId) { this.auditId = auditId; }

    public String getAgenceId() { return agenceId; }
    public void setAgenceId(String agenceId) { this.agenceId = agenceId; }

    public LocalDateTime getDateAudit() { return dateAudit; }
    public void setDateAudit(LocalDateTime dateAudit) { this.dateAudit = dateAudit; }

    public boolean isAuditReussi() { return auditReussi; }
    public void setAuditReussi(boolean auditReussi) { this.auditReussi = auditReussi; }

    public List<String> getAnomalies() { return anomalies; }
    public void setAnomalies(List<String> anomalies) {
        this.anomalies = anomalies;
        this.nombreAnomalies = anomalies != null ? anomalies.size() : 0;
    }

    public int getNombreAnomalies() { return nombreAnomalies; }
    public void setNombreAnomalies(int nombreAnomalies) { this.nombreAnomalies = nombreAnomalies; }
}