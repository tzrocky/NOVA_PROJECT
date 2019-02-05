package com.websystique.springboot.repositories;
 
import com.websystique.springboot.model.FactureMoniteur;
import com.websystique.springboot.model.Moniteur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface FactureMoniteurRepository extends JpaRepository<FactureMoniteur, Long> {
    FactureMoniteur findByNumFacture(String numFacture);
    List<FactureMoniteur> findByMoniteur (Moniteur moniteur);

}