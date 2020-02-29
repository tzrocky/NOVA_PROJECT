
package com.websystique.springboot.service;
 
import com.websystique.springboot.model.FactureEleve;
import com.websystique.springboot.model.Eleve;

import java.util.List;
 
public interface FactureEleveService {
     
    FactureEleve findById(Long id);
 
    FactureEleve findByNumFacture(String numFacture);
    
    List<FactureEleve> findByEleve(Eleve eleve);
 
    void saveFactureEleve(FactureEleve factureEleve);
 
    void updateFactureEleve(FactureEleve factureEleve);
 
    void deleteFactureEleveById(Long id);
 
    void deleteAllFacturesEleve();
 
    List<FactureEleve> findAllFacturesEleve();
 
    boolean isFactureEleveExist(FactureEleve factureEleve);
}