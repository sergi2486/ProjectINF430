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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="facultes")
public class Faculte implements Serializable {
	
	@Id
	@NotNull(message="Ce champ est obligatoire")
	@Size(min=3, max=20)
	private String nom;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@OneToMany(mappedBy="faculte")
	private Collection<Filiere> filieres;
	
	
	@OneToMany(mappedBy="ressource")
	private Collection<Reservation> reservations;
	
	public Faculte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Faculte(String nom, Date date) {
		super();
		this.nom = nom;
		//this.description = description;
		this.date = date;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Collection<Filiere> getFilieres() {
		return filieres;
	}
	public void setFilieres(Collection<Filiere> filieres) {
		this.filieres = filieres;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	

}
