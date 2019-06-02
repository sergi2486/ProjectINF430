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
@Table(name="ues")
public class UE implements Serializable {

	
	@Id
	@NotNull(message="Ce champ est obligatoire !")
	@Size(min=2, max=15)
	private String nom;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
//	@ManyToOne
//	@JoinColumn(name="id_classe")
//	private Classe classe;
	//@NotNull(message="Ce champ est obligatoire")
	private String classe;

	@OneToMany(mappedBy="ressource")
	private Collection<Reservation> reservations;
	
	public UE() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UE(String nom, Date date, String classe) {
		super();
		this.nom = nom;
		this.date = date;
		this.classe = classe;
		//this.classe = classe;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	public Classe getClasse() {
//		return classe;
//	}
//
//	public void setClasse(Classe classe) {
//		this.classe = classe;
//	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

}
