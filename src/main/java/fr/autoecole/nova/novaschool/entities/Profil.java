//package fr.autoecole.nova.novaschool.entities;
//
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//
///**
// * The persistent class for the profil database table.
// * 
// */
//@Entity
////@Table(name="profil")
////@NamedQuery(name="Profil.findAll", query="SELECT p FROM Profil p")
//public class Profil implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	private int id;
//
//	@Column(name="intitule_profil")
//	private String intituleProfil;
//
//	private String niveau;
//
//	public Profil() {
//	}
//
//	public int getId() {
//		return this.id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getIntituleProfil() {
//		return this.intituleProfil;
//	}
//
//	public void setIntituleProfil(String intituleProfil) {
//		this.intituleProfil = intituleProfil;
//	}
//
//	public String getNiveau() {
//		return this.niveau;
//	}
//
//	public void setNiveau(String niveau) {
//		this.niveau = niveau;
//	}
//
//}