package com.uy1.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reservations")
public class Reservation implements Serializable {

	
	@Id
	@GeneratedValue
	private Long id;

	//private Date date_debut;
	//private Date date_fin;
	
//	@ManyToOne
//	@JoinColumn(name="id_type_reservation")
//	private TypeReservation type_reservation;
	private String type_reservation;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	//@NotNull(message="Choisissez un ressource")
//	@ManyToOne
//	@JoinColumn(name="id_ressource")
//	private Ressource ressource;
	
	private String ressource;
	
//	@ManyToOne
//	@JoinColumn(name="id_faculte")
//	private Faculte faculte;
	private String faculte;
	
//	@ManyToOne
//	@JoinColumn(name="id_filiere")
//	private Filiere filiere;
	private String filiere;
	
//	@ManyToOne
//	@JoinColumn(name="id_classe")
//	private Classe classe;
	private String classe;
	
//	@ManyToOne
//	@JoinColumn(name="id_ue")
//	private UE ue;
	private String ue;
	
	@ManyToMany(mappedBy="reservations")
	private Collection<User> users;
	
	
	private Date annee1;
	private Date annee2;
	private String semestre;

	//@NotNull(message="Un jour est obligatoire")
	private String jour;
	
	//@NotNull(message="Heure de début")

	//@Temporal(TemporalType.TIME)
	//@DateTimeFormat(pattern="HH:mm")
	private String heure_deb;
	//@NotNull(message="Heure de fin")
	//@Temporal(TemporalType.TIME)
	//@DateTimeFormat(pattern="HH:mm")
	private String heure_fin;
	
	private String Enseignant;

	//private String observation;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Date date_debut, Date date_fin, String type_reservateion, String ressource, String faculte,
			String filiere, String classe, String ue, Date annee1, Date annee2, String semestre, String jour, String enseignant, String observation) {
		super();
		//this.date_debut = date_debut;
		//this.date_fin = date_fin;
	//	this.type_reservation = type_reservation;
		this.ressource = ressource;
		this.faculte = faculte;
		this.filiere = filiere;
		this.classe = classe;
		this.ue = ue;
		this.annee1 = annee1;
		this.annee2 = annee2;
		this.semestre = semestre;
		this.jour = jour;
		//this.heure_deb = heure_deb;
		//this.heure_fin = heure_fin;
		Enseignant = enseignant;
		//this.observation = observation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Date getDate_debut() {
//		return date_debut;
//	}
//
//	public void setDate_debut(Date date_debut) {
//		this.date_debut = date_debut;
//	}
//
//	public Date getDate_fin() {
//		return date_fin;
//	}
//
//	public void setDate_fin(Date date_fin) {
//		this.date_fin = date_fin;
//	}
//
//	public String getType_reservateion() {
//		return type_reservation;
//	}
//
//	public void setType_reservation(String type_reservation) {
//		this.type_reservation = type_reservation;
//	}

	public String getRessource() {
		return ressource;
	}

	public void setRessource(String ressource) {
		this.ressource = ressource;
	}

	public String getFaculte() {
		return faculte;
	}

	public void setFaculte(String faculte) {
		this.faculte = faculte;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getUe() {
		return ue;
	}

	public void setUe(String ue) {
		this.ue = ue;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Date getAnnee1() {
		return annee1;
	}

	public void setAnnee1(Date annee1) {
		this.annee1 = annee1;
	}

	public Date getAnnee2() {
		return annee2;
	}

	public void setAnnee2(Date annee2) {
		this.annee2 = annee2;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getHeure_deb() {
		return heure_deb;
	}

	public void setHeure_deb(String heure_deb) {
		this.heure_deb = heure_deb;
	}

	public String getHeure_fin() {
		return heure_fin;
	}

	public void setHeure_fin(String heure_fin) {
		this.heure_fin = heure_fin;
	}

	public String getEnseignant() {
		return Enseignant;
	}

	public void setEnseignant(String enseignant) {
		Enseignant = enseignant;
	}

//	public String getObservation() {
//		return observation;
//	}
//
//	public void setObservation(String observation) {
//		this.observation = observation;
//	}

}
