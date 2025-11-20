package org.formation.proxibanque.repository;

import org.formation.proxibanque.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, String> {

}