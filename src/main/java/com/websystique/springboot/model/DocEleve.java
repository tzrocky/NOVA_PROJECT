package com.websystique.springboot.model;


import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the document database table.
 * 
 */
@Entity
@Table(name="doc_eleve")
@NamedQuery(name="DocEleve.findAll", query="SELECT p FROM DocEleve p")
public class DocEleve implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_document")
	private Document doc;

	@Column(name="id_eleve")
	private Eleve eleve;
	
	@Column(name="lien_document")
	private String lienDocument;

	public DocEleve() {
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the doc
	 */
	public Document getDoc() {
		return doc;
	}

	/**
	 * @param doc the doc to set
	 */
	public void setDoc(Document doc) {
		this.doc = doc;
	}

	/**
	 * @return the eleve
	 */
	public Eleve getEleve() {
		return eleve;
	}

	/**
	 * @param eleve the eleve to set
	 */
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	/**
	 * @return the lienDocument
	 */
	public String getLienDocument() {
		return lienDocument;
	}

	/**
	 * @param lienDocument the lienDocument to set
	 */
	public void setLienDocument(String lienDocument) {
		this.lienDocument = lienDocument;
	}



}