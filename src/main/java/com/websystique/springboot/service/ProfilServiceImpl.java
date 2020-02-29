package com.websystique.springboot.service;
 
import java.util.List;
 
import com.websystique.springboot.model.Profil;
import com.websystique.springboot.repositories.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
 
 
@Service("profilService")
@Transactional
public class ProfilServiceImpl implements ProfilService{
 
    @Autowired
    private ProfilRepository profilRepository;
 
    public Profil findById(Long id) {
        return profilRepository.findOne(id);
    }
 
//    public Profil findByNom(String name) {
//        return profilRepository.findByIntitule(name);
//    }
 
    public void saveProfil(Profil profil) {
        profilRepository.save(profil);
    }
 
    public void updateProfil(Profil profil){
        saveProfil(profil);
    }
 
    public void deleteProfilById(Long id){
        profilRepository.delete(id);
    }
 
    public void deleteAllProfils(){
        profilRepository.deleteAll();
    }
 
    public List<Profil> findAllProfils(){
        return profilRepository.findAll();
    }
 
    public boolean isProfilExist(Profil profil) {
        return findByIntitule(profil.getIntituleProfil()) != null;
    }

	@Override
	public Profil findByIntitule(String name) {
        return profilRepository.findByIntituleProfil(name);
	}
 
}