
package com.websystique.springboot.service;
 
import com.websystique.springboot.model.FactureMoniteur;
import com.websystique.springboot.model.Moniteur;

import java.util.List;
 
public interface FactureMoniteurService {
     
    FactureMoniteur findById(Long id);
 
    FactureMoniteur findByNumFacture(String numFacture);
    
    List<FactureMoniteur> findByMoniteur(Moniteur moniteur);
 
    void saveFactureMoniteur(FactureMoniteur factureMoniteur);
 
    void updateFactureMoniteur(FactureMoniteur factureMoniteur);
 
    void deleteFactureMoniteurById(Long id);
 
    void deleteAllFacturesMoniteur();
 
    List<FactureMoniteur> findAllFacturesMoniteur();
 
    boolean isFactureMoniteurExist(FactureMoniteur factureMoniteur);
}