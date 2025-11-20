package org.formation.proxibanque.repository;

import org.formation.proxibanque.model.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConseillerRepository extends JpaRepository<Conseiller, Long> {

    List<Conseiller> findByAgenceIdAgence(String idAgence);

    @Query("SELECT c FROM Conseiller c WHERE SIZE(c.clients) < 10")
    List<Conseiller> findConseillersAvecCapacite();
}