package org.formation.proxibanque.dto;

public class ClientDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;
    private String email;
    private boolean clientFortune;
    private String nomConseiller;
    private double soldeTotal;

    public ClientDTO() {}

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

    public String getNomConseiller() { return nomConseiller; }
    public void setNomConseiller(String nomConseiller) { this.nomConseiller = nomConseiller; }

    public double getSoldeTotal() { return soldeTotal; }
    public void setSoldeTotal(double soldeTotal) { this.soldeTotal = soldeTotal; }
}