package com.websystique.springboot.repositories;
 
import com.websystique.springboot.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    Document findByCode(String code);
}