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
@Table(name="filieres")
public class Filiere implements Serializable {

	@Id
	@NotNull(message="Ce champ est obligatoire")
	@Size(min=2, max=25)
	private String nom;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
//	@ManyToOne
//	@JoinColumn(name="id_faculte")
//	private Faculte faculte;
	
	//@NotNull(message="Ce champ est obligatoire")
	private String faculte;
	
	@OneToMany(mappedBy="filiere")
	private Collection<Classe> classes;
	
	@OneToMany(mappedBy="filiere")
	private Collection<User> users;
	
	@OneToMany(mappedBy="ressource")
	private Collection<Reservation> reservations;
	

	
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Filiere(String nom, Date date, String faculte) {
		super();
		this.nom = nom;
		this.date = date;
		this.faculte = faculte;
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
//	public void setDescription(String description) {
//		this.description = description;
//	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
//	public Faculte getFaculte() {
//		return faculte;
//	}
//	public void setFaculte(Faculte faculte) {
//		this.faculte = faculte;
//	}
	public Collection<Classe> getClasses() {
		return classes;
	}
	public void setClasses(Collection<Classe> classes) {
		this.classes = classes;
	}
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	public Collection<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	public String getFaculte() {
		return faculte;
	}
	public void setFaculte(String faculte) {
		this.faculte = faculte;
	}
	
}
