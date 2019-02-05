package com.websystique.springboot.repositories;
 
import com.websystique.springboot.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long> {
    Eleve findByName(String name);
}