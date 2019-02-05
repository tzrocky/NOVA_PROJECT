package com.websystique.springboot.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the profil database table.
 * 
 */
@Entity
@Table(name="profil")
@NamedQuery(name="Profil.findAll", query="SELECT p FROM Profil p")
public class Profil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="intitule_profil")
	private String intituleProfil;

	@Column(name="niveau")
	private String niveau;

	public Profil() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntituleProfil() {
		return this.intituleProfil;
	}

	public void setIntituleProfil(String intituleProfil) {
		this.intituleProfil = intituleProfil;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

}