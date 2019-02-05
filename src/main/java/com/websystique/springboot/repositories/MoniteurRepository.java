package com.websystique.springboot.repositories;
 
import com.websystique.springboot.model.FactureMoniteur;
import com.websystique.springboot.model.Moniteur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
@Repository
public interface MoniteurRepository extends JpaRepository<Moniteur, Long> {
 
    Moniteur findByNom(String name);
    
    @Query(nativeQuery = true, value =
            "SELECT " +
            "    m.factureMoniteur " +
            "FROM " +
            "    Moniteur m ")
    List<FactureMoniteur> getAllFactureMoniteur(Moniteur moniteur);
}