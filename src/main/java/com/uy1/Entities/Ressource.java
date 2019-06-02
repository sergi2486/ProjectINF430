package com.uy1.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="ressources")
public class Ressource implements Serializable {
	
	@Id
	@NotNull(message="Ce champ est obligatoire !")
	@Size(min=2, max=20)
	private String nom;

	private String carac;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
//	@ManyToOne
//	@JoinColumn(name="id_user")
//	private User user;
    
	private String user;
	
//	@ManyToOne
//	@JoinColumn(name="id_faculte")
//	private Faculte faculte;
	//@NotNull(message="Ce champ est obligatoire !")
	private String faculte;
	
//	@ManyToOne
//	@JoinColumn(name="type_ressource")
//	private TypeRessource type_ressource;
	//@NotNull(message="Ce champ est obligatoire")
	private String type_ressource;
	
	private String filiere;
	
	@OneToMany(mappedBy="ressource")
	private Collection<Reservation> reservations;
	
	

	public Ressource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ressource(String nom, Date date, String user, String faculte, String type_ressource,
			String filiere, String carac) {
		super();
		this.nom = nom;
		//this.description = description;
		this.date = date;
		this.user = user;
		this.faculte = faculte;
		this.type_ressource = type_ressource;
		this.filiere = filiere;
		this.carac = carac;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
/*
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Faculte getFaculte() {
		return faculte;
	}

	public void setFaculte(Faculte faculte) {
		this.faculte = faculte;
	}

	public TypeRessource getType_ressource() {
		return type_ressource;
	}

	public void setType_ressource(TypeRessource type_ressource) {
		this.type_ressource = type_ressource;
	}
*/
	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}



	public void setUser(String user) {
		this.user = user;
	}

	public void setFaculte(String faculte) {
		this.faculte = faculte;
	}

	public void setType_ressource(String type_ressource) {
		this.type_ressource = type_ressource;
	}

//	public String getDepartement() {
//		return departement;
//	}
//
//	public void setDepartement(String departement) {
//		this.departement = departement;
//	}
	

	public String getUser() {
		return user;
	}



	public String getCarac() {
		return carac;
	}

	public void setCarac(String carac) {
		this.carac = carac;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getFaculte() {
		return faculte;
	}

	public String getType_ressource() {
		return type_ressource;
	}
	
	

}
