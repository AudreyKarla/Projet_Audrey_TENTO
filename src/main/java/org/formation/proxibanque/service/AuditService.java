package org.formation.proxibanque.service;

import org.formation.proxibanque.model.Agence;
import org.formation.proxibanque.model.Audit;
import org.formation.proxibanque.model.CompteCourant;
import org.formation.proxibanque.repository.AgenceRepository;
import org.formation.proxibanque.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {

    @Autowired
    private AgenceRepository agenceRepository;

    @Autowired
    private CompteRepository compteRepository;

    public Audit auditerAgence(String idAgence) {
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence non trouvée: " + idAgence));

        Audit audit = new Audit(agence);
        boolean auditReussi = true;

        List<CompteCourant> comptesParticuliersDebiteurs = compteRepository.findComptesParticuliersDebiteurs();
        if (!comptesParticuliersDebiteurs.isEmpty()) {
            auditReussi = false;
            for (CompteCourant compte : comptesParticuliersDebiteurs) {
                String anomalie = String.format("Compte particulier %s (Client: %s) débiteur de %.2f€",
                        compte.getNumeroCompte(),
                        compte.getClient().getNom(),
                        compte.getSolde());
                audit.ajouterAnomalie(anomalie);
            }
        }

        List<CompteCourant> comptesEntreprisesDebiteurs = compteRepository.findComptesEntreprisesDebiteurs();
        if (!comptesEntreprisesDebiteurs.isEmpty()) {
            auditReussi = false;
            for (CompteCourant compte : comptesEntreprisesDebiteurs) {
                String anomalie = String.format("Compte entreprise %s (Client: %s) débiteur de %.2f€",
                        compte.getNumeroCompte(),
                        compte.getClient().getNom(),
                        compte.getSolde());
                audit.ajouterAnomalie(anomalie);
            }
        }

        audit.setAuditReussi(auditReussi);
        return audit;
    }

    public List<CompteCourant> getComptesParticuliersDebiteurs() {
        return compteRepository.findComptesParticuliersDebiteurs();
    }

    public List<CompteCourant> getComptesEntreprisesDebiteurs() {
        return compteRepository.findComptesEntreprisesDebiteurs();
    }
}