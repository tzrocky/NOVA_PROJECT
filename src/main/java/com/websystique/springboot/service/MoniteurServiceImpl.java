package com.websystique.springboot.service;
 
import java.util.List;

import com.websystique.springboot.model.FactureMoniteur;
import com.websystique.springboot.model.Moniteur;
import com.websystique.springboot.repositories.MoniteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
 
 
@Service("moniteurService")
@Transactional
public class MoniteurServiceImpl implements MoniteurService{
 
    @Autowired
    private MoniteurRepository moniteurRepository;
 
    public Moniteur findById(Long id) {
        return moniteurRepository.findOne(id);
    }
 
    public Moniteur findByNom(String name) {
        return moniteurRepository.findByNom(name);
    }
 
    public void saveMoniteur(Moniteur moniteur) {
        moniteurRepository.save(moniteur);
    }
 
    public void updateMoniteur(Moniteur moniteur){
        saveMoniteur(moniteur);
    }
 
    public void deleteMoniteurById(Long id){
        moniteurRepository.delete(id);
    }
 
    public void deleteAllMoniteurs(){
        moniteurRepository.deleteAll();
    }
 
    public List<Moniteur> findAllMoniteurs(){
        return moniteurRepository.findAll();
    }
 
    public boolean isMoniteurExist(Moniteur moniteur) {
        return findByNom(moniteur.getNom()) != null;
    }

	@Override
	public List<FactureMoniteur> getAllFacturesByMoniteur(Moniteur moniteur) {
		return moniteurRepository.getAllFactureMoniteur(moniteur);
	}
 
}