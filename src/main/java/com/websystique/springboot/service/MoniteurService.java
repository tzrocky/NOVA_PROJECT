
package com.websystique.springboot.service;
 
import com.websystique.springboot.model.FactureMoniteur;
import com.websystique.springboot.model.Moniteur;
import java.util.List;
 
public interface MoniteurService {
     
    Moniteur findById(Long id);
 
    Moniteur findByNom(String name);
 
    void saveMoniteur(Moniteur moniteur);
 
    void updateMoniteur(Moniteur moniteur);
    
    List<FactureMoniteur> getAllFacturesByMoniteur(Moniteur moniteur);
 
    void deleteMoniteurById(Long id);
 
    void deleteAllMoniteurs();
 
    List<Moniteur> findAllMoniteurs();
 
    boolean isMoniteurExist(Moniteur moniteur);
}