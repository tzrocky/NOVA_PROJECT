package com.websystique.springboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the individu database table.
 * 
 */
@Entity
@Table(name="MONITEUR")
//@NamedQuery(name="Individu.findAll", query="SELECT i FROM Individu i")
public class Moniteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="matricule")
	private String matricule;

	@Column(name="nom")
	private String nom;

	@Column(name="prenom")
	private String prenom;
	
	@ManyToOne
	@JoinColumn(name = "id_profil")
	private Profil profil;

	@Column(name="SALARY")
	private double salary;
//	
//	@OneToMany(targetEntity=FactureMoniteur.class)
//    private List<FactureMoniteur> factureMoniteurlist;
	
	/**
	 * @return the profil
	 */
	public Profil getProfil() {
		return profil;
	}

	/**
	 * @param profil the profil to set
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
	}

//	@OneToMany(cascade = { CascadeType.ALL })
//	@JoinColumn(name = "id_moniteur")
//	private Collection<Reservation> reservations = new ArrayList<Reservation>();

	public Moniteur() {
	}

	public Long getId() {
		return this.id;
	}

//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
//	 public List<FactureMoniteur> getFactureMoniteurList() {
//	      return factureMoniteurlist;
//	   }
//
//	   public void setFactureMoniteurList(List<FactureMoniteur> factureMoniteurlist) {
//	      this.factureMoniteurlist = factureMoniteurlist;
//	   }
	
//	public Collection<Reservation> getReservations() {
//	    return reservations;
//	  }
//
//	  public void setReservations(Collection<Reservation> pReservations) {
//	    this.reservations = pReservations;
//	  }

}