
package com.websystique.springboot.service;
 
import com.websystique.springboot.model.Document;
import java.util.List;
 
public interface DocumentService {
     
    Document findById(Long id);
 
    Document findByCode(String type);
 
    void saveDocument(Document document);
 
    void updateDocument(Document document);
 
    void deleteDocumentById(Long id);
 
    void deleteAllDocuments();
 
    List<Document> findAllDocuments();
 
    boolean isDocumentExist(Document document);
}