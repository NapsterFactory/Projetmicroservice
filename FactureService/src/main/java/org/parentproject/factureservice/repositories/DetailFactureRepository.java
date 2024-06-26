package org.parentproject.factureservice.repositories;

import org.parentproject.factureservice.entities.DetailFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailFactureRepository extends JpaRepository<DetailFacture, Long> {

}
