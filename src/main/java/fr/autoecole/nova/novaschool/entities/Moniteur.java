//package fr.autoecole.nova.novaschool.entities;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collection;
//import javax.persistence.*;
//
///**
// * The persistent class for the individu database table.
// * 
// */
//@Entity
////@Table(name="individu")
////@NamedQuery(name="Individu.findAll", query="SELECT i FROM Individu i")
//public class Moniteur implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	private int id;
//
//	@Column(name="matricule")
//	private String matricule;
//
//	@Column(name="nom")
//	private String nom;
//
//	@Column(name="prenom")
//	private String prenom;
//	
//	@ManyToOne
//	@JoinColumn(name = "id_profil")
//	private Profil profil;
//	
//	/**
//	 * @return the profil
//	 */
//	public Profil getProfil() {
//		return profil;
//	}
//
//	/**
//	 * @param profil the profil to set
//	 */
//	public void setProfil(Profil profil) {
//		this.profil = profil;
//	}
//
//	@OneToMany(cascade = { CascadeType.ALL })
//	@JoinColumn(name = "id_moniteur")
//	private Collection<Reservation> reservations = new ArrayList<Reservation>();
//
//	public Moniteur() {
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
//	public String getMatricule() {
//		return this.matricule;
//	}
//
//	public void setMatricule(String matricule) {
//		this.matricule = matricule;
//	}
//
//	public String getNom() {
//		return this.nom;
//	}
//
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
//
//	public String getPrenom() {
//		return this.prenom;
//	}
//
//	public void setPrenom(String prenom) {
//		this.prenom = prenom;
//	}
//	
//	public Collection<Reservation> getReservations() {
//	    return reservations;
//	  }
//
//	  public void setReservations(Collection<Reservation> pReservations) {
//	    this.reservations = pReservations;
//	  }
//
//}