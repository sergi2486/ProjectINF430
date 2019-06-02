package com.uy1.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlSchema;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="classes")
public class Classe implements Serializable {

	@Id
	@NotNull(message="Ce champ est obligatoire !")
	@Size(min=2, max=20)
	private String nom;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
//	@ManyToOne
//	@JoinColumn(name="id_filiere")
//	private Filiere filiere;
	//@NotEmpty(message="Ce champ est obligatoire !")
	//@NotNull(message="Ce champ est obligatoire")
	private String filiere;

	@OneToMany(mappedBy="classe")
	private Collection<UE> ues;
	
	@OneToMany(mappedBy="ressource")
	private Collection<Reservation> reservations;
	
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classe(String nom, Date date, String filiere) {
		super();
		this.nom = nom;
		this.date = date;
		this.filiere = filiere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	public Filiere getFiliere() {
//		return filiere;
//	}
//
//	public void setFiliere(Filiere filiere) {
//		this.filiere = filiere;
//	}

	public Collection<UE> getUes() {
		return ues;
	}

	public void setUes(Collection<UE> ues) {
		this.ues = ues;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}


	
	
}
