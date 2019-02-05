package com.websystique.springboot.service;
 
import java.util.List;
 
import com.websystique.springboot.model.Eleve;
import com.websystique.springboot.repositories.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
 
 
@Service("eleveService")
@Transactional
public class EleveServiceImpl implements EleveService{
 
    @Autowired
    private EleveRepository eleveRepository;
 
    public Eleve findById(Long id) {
        return eleveRepository.findOne(id);
    }
 
    public Eleve findByName(String name) {
        return eleveRepository.findByName(name);
    }
 
    public void saveEleve(Eleve eleve) {
        eleveRepository.save(eleve);
    }
 
    public void updateEleve(Eleve eleve){
        saveEleve(eleve);
    }
 
    public void deleteEleveById(Long id){
        eleveRepository.delete(id);
    }
 
    public void deleteAllEleves(){
        eleveRepository.deleteAll();
    }
 
    public List<Eleve> findAllEleves(){
        return eleveRepository.findAll();
    }
 
    public boolean isEleveExist(Eleve eleve) {
        return findByName(eleve.getName()) != null;
    }
 
}