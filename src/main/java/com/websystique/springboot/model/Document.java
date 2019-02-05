package com.websystique.springboot.model;


import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the document database table.
 * 
 */
@Entity
@Table(name="document")
@NamedQuery(name="Document.findAll", query="SELECT p FROM Document p")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="type")
	private String type;

	@Column(name="libelle")
	private String libelle;
	
	@Column(name="code")
	private String code;

	@Column(name="lien")
	private String lien;

	public Document() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the lien
	 */
	public String getLien() {
		return lien;
	}

	/**
	 * @param lien the lien to set
	 */
	public void setLien(String lien) {
		this.lien = lien;
	}


}