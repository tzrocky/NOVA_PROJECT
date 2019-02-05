package com.websystique.springboot.repositories;
 
import com.websystique.springboot.model.FactureEleve;
import com.websystique.springboot.model.Eleve;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface FactureEleveRepository extends JpaRepository<FactureEleve, Long> {
	FactureEleve findByNumFacture(String numFacture);
    List<FactureEleve> findByEleve (Eleve eleve);

}