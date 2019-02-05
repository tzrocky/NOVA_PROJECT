
package com.websystique.springboot.service;
 
import com.websystique.springboot.model.Eleve;
import java.util.List;
 
public interface EleveService {
     
    Eleve findById(Long id);
 
    Eleve findByName(String name);
 
    void saveEleve(Eleve eleve);
 
    void updateEleve(Eleve eleve);
 
    void deleteEleveById(Long id);
 
    void deleteAllEleves();
 
    List<Eleve> findAllEleves();
 
    boolean isEleveExist(Eleve eleve);
}