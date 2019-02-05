/**
 * 
 */
package com.websystique.springboot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="ELEVE")
public class Eleve implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = -2588224148275227849L;

	@Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;

   @NotEmpty
   @Column(name="NAME", nullable=false)
   private String name;
   
   @Column(name="PRENOM")
   private String prenom;
   
   @NotEmpty
   @Column(name="ADRESSE", nullable=false)
   private String adresse;
   
   @NotEmpty
   @Column(name="EMAIL", nullable=false)
   private String email;
   

   @Column(name="AGE", nullable=false)
   private Integer age;
   
   @Column(name="MATRICULE", nullable=false)
   private String matricule;
   

	@ManyToOne
	@JoinColumn(name = "ID_PROFIL")
	private Profil profil;
	

//	@OneToMany(targetEntity=FactureEleve.class)
//	private Collection<FactureEleve> facturesEleve = new ArrayList<FactureEleve>();

//--- getter/setter omitted to save space
   
   /**
 * @return the id
 */
public Long getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @return the age
 */
public Integer getAge() {
	return age;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @param age the age to set
 */
public void setAge(Integer age) {
	this.age = age;
}

/**
 * @return the matricule
 */
public String getMatricule() {
	return matricule;
}

/**
 * @return the idProfil
 */
public Profil getProfil() {
	return profil;
}

/**
 * @param matricule the matricule to set
 */
public void setMatricule(String matricule) {
	this.matricule = matricule;
}

/**
 * @param idProfil the idProfil to set
 */
public void setProfil(Profil profil) {
	this.profil = profil;
}

/**
 * @return the prenom
 */
public String getPrenom() {
	return prenom;
}

/**
 * @param prenom the prenom to set
 */
public void setPrenom(String prenom) {
	this.prenom = prenom;
}

/**
 * @return the adresse
 */
public String getAdresse() {
	return adresse;
}

/**
 * @param adresse the adresse to set
 */
public void setAdresse(String adresse) {
	this.adresse = adresse;
}

/**
 * @return the email
 */
public String getEmail() {
	return email;
}

/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}

///**
// * @return the facturesEleve
// */
//public Collection<FactureEleve> getFacturesEleve() {
//	return facturesEleve;
//}
//
///**
// * @param facturesEleve the facturesEleve to set
// */
//public void setFacturesEleve(Collection<FactureEleve> facturesEleve) {
//	this.facturesEleve = facturesEleve;
//}
}