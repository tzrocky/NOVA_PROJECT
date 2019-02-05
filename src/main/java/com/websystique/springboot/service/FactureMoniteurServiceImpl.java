package com.websystique.springboot.service;
 
import java.util.List;
 
import com.websystique.springboot.model.FactureMoniteur;
import com.websystique.springboot.model.Moniteur;
import com.websystique.springboot.repositories.FactureMoniteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
 
 
@Service("factureMoniteurService")
@Transactional
public class FactureMoniteurServiceImpl implements FactureMoniteurService{
 
    @Autowired
    private FactureMoniteurRepository factureMoniteurRepository;
 
    public FactureMoniteur findById(Long id) {
        return factureMoniteurRepository.findOne(id);
    }
 
    public FactureMoniteur findByNumFacture(String numFact) {
        return factureMoniteurRepository.findByNumFacture(numFact);
    }
    
    public List<FactureMoniteur> findByMoniteur (Moniteur moniteur) {
        return factureMoniteurRepository.findByMoniteur(moniteur);
    }
 
    public void saveFactureMoniteur(FactureMoniteur factureMoniteur) {
        factureMoniteurRepository.save(factureMoniteur);
    }
 
    public void updateFactureMoniteur(FactureMoniteur factureMoniteur){
        saveFactureMoniteur(factureMoniteur);
    }
 
    public void deleteFactureMoniteurById(Long id){
        factureMoniteurRepository.delete(id);
    }
 
    public void deleteAllFacturesMoniteur(){
        factureMoniteurRepository.deleteAll();
    }
 
    public List<FactureMoniteur> findAllFacturesMoniteur(){
        return factureMoniteurRepository.findAll();
    }
 
    public boolean isFactureMoniteurExist(FactureMoniteur factureMoniteur) {
        return findByNumFacture(factureMoniteur.getNumFacture()) != null;
    }
}