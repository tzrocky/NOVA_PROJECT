
package com.websystique.springboot.service;
 
import com.websystique.springboot.model.Profil;
import java.util.List;
 
public interface ProfilService {
     
    Profil findById(Long id);
 
    Profil findByIntitule(String name);
 
    void saveProfil(Profil profil);
 
    void updateProfil(Profil profil);
 
    void deleteProfilById(Long id);
 
    void deleteAllProfils();
 
    List<Profil> findAllProfils();
 
    boolean isProfilExist(Profil profil);
}