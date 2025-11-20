package org.formation.proxibanque.repository;

import org.formation.proxibanque.model.Compte;
import org.formation.proxibanque.model.CompteCourant;
import org.formation.proxibanque.model.CompteEpargne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    Optional<Compte> findByNumeroCompte(String numeroCompte);

    List<Compte> findByClientId(Long clientId);

    @Query("SELECT cc FROM CompteCourant cc WHERE cc.solde < -5000")
    List<CompteCourant> findComptesParticuliersDebiteurs();

    @Query("SELECT cc FROM CompteCourant cc WHERE cc.solde < -50000")
    List<CompteCourant> findComptesEntreprisesDebiteurs();

    List<CompteCourant> findBySoldeLessThan(double solde);

    List<CompteEpargne> findByTauxRemunerationGreaterThan(double taux);
}