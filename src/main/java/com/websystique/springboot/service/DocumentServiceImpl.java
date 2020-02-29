package com.websystique.springboot.service;
 
import java.util.List;
 
import com.websystique.springboot.model.Document;
import com.websystique.springboot.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
 
 
@Service("documentService")
@Transactional
public class DocumentServiceImpl implements DocumentService{
 
    @Autowired
    private DocumentRepository documentRepository;
 
    public Document findById(Long id) {
        return documentRepository.findOne(id);
    }
 
//    public Document findByNom(String name) {
//        return documentRepository.findByIntitule(name);
//    }
 
    public void saveDocument(Document document) {
        documentRepository.save(document);
    }
 
    public void updateDocument(Document document){
        saveDocument(document);
    }
 
    public void deleteDocumentById(Long id){
        documentRepository.delete(id);
    }
 
    public void deleteAllDocuments(){
        documentRepository.deleteAll();
    }
 
    public List<Document> findAllDocuments(){
        return documentRepository.findAll();
    }
 
    public boolean isDocumentExist(Document document) {
        return findByCode(document.getCode()) != null;
    }

	@Override
	public Document findByCode(String code) {
        return documentRepository.findByCode(code);
	}
 
}