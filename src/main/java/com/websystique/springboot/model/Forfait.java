/**
 * 
 */
package com.websystique.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="FORFAIT")
public class Forfait implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = -2588224148275227849L;

	@Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;

   @Column(name="TYPE", nullable=false)
   private String type;

   @Column(name="NB_HEURES", nullable=false)
   private int nbHeures;
   
   @Column(name="MONTANT", nullable=false)
   private double montant;

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
 * @return the nbHeures
 */
public int getNbHeures() {
	return nbHeures;
}

/**
 * @param nbHeures the nbHeures to set
 */
public void setNbHeures(int nbHeures) {
	this.nbHeures = nbHeures;
}

/**
 * @return the montant
 */
public double getMontant() {
	return montant;
}

/**
 * @param montant the montant to set
 */
public void setMontant(double montant) {
	this.montant = montant;
}

}