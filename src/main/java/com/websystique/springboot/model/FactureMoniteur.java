/**
 * 
 */
package com.websystique.springboot.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

@Entity
@Table(name="FACTURE_MONITEUR")
public class FactureMoniteur implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = -2588224148275227849L;

	@Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;

   @Column(name="QUANTITE", nullable=false)
   private Long quantite;

   @Column(name="PRIX_UNITAIRE", nullable=false)
   private double prixUnitaire;
//
//	@ManyToOne
//	@JoinColumn(name = "ID_RESERVATION")
//	private Reservation reservation;
	
	@Column(name="NUM_FACTURE", nullable=false)
	private String numFacture;
	
	@ManyToOne
	@JoinColumn(name = "id_moniteur")
	//@JsonBackReference
	private Moniteur moniteur;

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
 * @return the quantite
 */
public Long getQuantite() {
	return quantite;
}

/**
 * @param quantite the quantite to set
 */
public void setQuantite(Long quantite) {
	this.quantite = quantite;
}

/**
 * @return the prixUnitaire
 */
public double getPrixUnitaire() {
	return prixUnitaire;
}

/**
 * @param prixUnitaire the prixUnitaire to set
 */
public void setPrixUnitaire(double prixUnitaire) {
	this.prixUnitaire = prixUnitaire;
}

///**
// * @return the reservation
// */
//public Reservation getReservation() {
//	return reservation;
//}
//
///**
// * @param reservation the reservation to set
// */
//public void setReservation(Reservation reservation) {
//	this.reservation = reservation;
//}

/**
 * @return the numFacture
 */
public String getNumFacture() {
	return numFacture;
}

/**
 * @param numFacture the numFacture to set
 */
public void setNumFacture(String numFacture) {
	this.numFacture = numFacture;
}

/**
 * @return the moniteur
 */
public Moniteur getMoniteur() {
	return moniteur;
}

/**
 * @param moniteur the moniteur to set
 */
public void setMoniteur(Moniteur moniteur) {
	this.moniteur = moniteur;
}

}