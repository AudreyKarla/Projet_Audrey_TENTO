package org.formation.proxibanque.service;

import org.formation.proxibanque.model.Compte;
import org.formation.proxibanque.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VirementService {

    @Autowired
    private CompteRepository compteRepository;

    public boolean effectuerVirement(String compteSource, String compteDestination, double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif");
        }

        Compte source = compteRepository.findByNumeroCompte(compteSource)
                .orElseThrow(() -> new RuntimeException("Compte source non trouvé: " + compteSource));

        Compte destination = compteRepository.findByNumeroCompte(compteDestination)
                .orElseThrow(() -> new RuntimeException("Compte destination non trouvé: " + compteDestination));

        if (compteSource.equals(compteDestination)) {
            throw new IllegalArgumentException("Impossible d'effectuer un virement vers le même compte");
        }

        boolean debitReussi = source.debiter(montant);

        if (debitReussi) {
            destination.crediter(montant);
            compteRepository.save(source);
            compteRepository.save(destination);
            return true;
        } else {
            throw new RuntimeException("Solde insuffisant pour effectuer le virement");
        }
    }

    public boolean verifierSoldeSuffisant(String numeroCompte, double montant) {
        Compte compte = compteRepository.findByNumeroCompte(numeroCompte)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé: " + numeroCompte));
        return compte.getSolde() >= montant;
    }

    public double getSoldeCompte(String numeroCompte) {
        Compte compte = compteRepository.findByNumeroCompte(numeroCompte)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé: " + numeroCompte));
        return compte.getSolde();
    }
}