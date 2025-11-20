package org.formation.proxibanque.repository;

import org.formation.proxibanque.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByNomContainingIgnoreCase(String nom);

    List<Client> findByConseillerId(Long conseillerId);

    @Query("SELECT c FROM Client c WHERE c.clientFortune = true")
    List<Client> findClientsFortunes();

    @Query("SELECT c FROM Client c WHERE (SELECT SUM(compte.solde) FROM c.comptes compte) > 500000")
    List<Client> findClientsAvecSoldeSuperieur500K();
}