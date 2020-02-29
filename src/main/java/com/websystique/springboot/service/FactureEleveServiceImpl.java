package com.websystique.springboot.service;
 
import java.util.List;
 
import com.websystique.springboot.model.FactureEleve;
import com.websystique.springboot.model.Eleve;
import com.websystique.springboot.repositories.FactureEleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
 
 
@Service("factureEleveService")
@Transactional
public class FactureEleveServiceImpl implements FactureEleveService{
 
    @Autowired
    private FactureEleveRepository factureEleveRepository;
 
    public FactureEleve findById(Long id) {
        return factureEleveRepository.findOne(id);
    }
 
    public FactureEleve findByNumFacture(String numFact) {
        return factureEleveRepository.findByNumFacture(numFact);
    }
    
    public List<FactureEleve> findByEleve (Eleve eleve) {
        return factureEleveRepository.findByEleve(eleve);
    }
 
    public void saveFactureEleve(FactureEleve factureEleve) {
        factureEleveRepository.save(factureEleve);
    }
 
    public void updateFactureEleve(FactureEleve factureEleve){
        saveFactureEleve(factureEleve);
    }
 
    public void deleteFactureEleveById(Long id){
        factureEleveRepository.delete(id);
    }
 
    public void deleteAllFacturesEleve(){
        factureEleveRepository.deleteAll();
    }
 
    public List<FactureEleve> findAllFacturesEleve(){
        return factureEleveRepository.findAll();
    }
 
    public boolean isFactureEleveExist(FactureEleve factureEleve) {
        return findByNumFacture(factureEleve.getNumFacture()) != null;
    }
}