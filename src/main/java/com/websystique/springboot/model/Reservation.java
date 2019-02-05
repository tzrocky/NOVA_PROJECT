package com.websystique.springboot.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@Table(name="reservation")
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="horaire_debut")
	private Date horaireDebut;

	@Temporal(TemporalType.DATE)
	@Column(name="horaire_fin")
	private Date horaireFin;
	
//	@Column(name="id_individu")e         o
//	private int idIndividu;
	
	@ManyToOne
	@JoinColumn(name = "id_eleve")
	private Eleve eleve;
	
	@ManyToOne
	@JoinColumn(name = "id_moniteur")
	private Moniteur moniteur;

	@Column(name="lieu_reservation")
	private String lieuReservation;
	
	public Reservation() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHoraireDebut() {
		return this.horaireDebut;
	}

	public void setHoraireDebut(Date horaireDebut) {
		this.horaireDebut = horaireDebut;
	}

	public Date getHoraireFin() {
		return this.horaireFin;
	}

	public void setHoraireFin(Date horaireFin) {
		this.horaireFin = horaireFin;
	}

	public String getLieuReservation() {
		return this.lieuReservation;
	}

	public void setLieuReservation(String lieuReservation) {
		this.lieuReservation = lieuReservation;
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

	/**
	 * @return the montantFacture
	 */
}