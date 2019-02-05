package com.websystique.springboot.repositories;
 
import com.websystique.springboot.model.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {
    Profil findByIntituleProfil(String name);
}