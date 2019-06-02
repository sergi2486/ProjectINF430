package com.uy1.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="historiques")
public class Historique implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String action;
	private String nom;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@DateTimeFormat(pattern="HHmm")
	private Date heure;
	private String jour;
	public Historique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Historique(String action, String nom, Date date, Date heure, String jour) {
		super();
		this.action = action;
		this.nom = nom;
		this.date = date;
		this.heure = heure;
		this.jour = jour;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
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
	public Date getHeure() {
		return heure;
	}
	public void setHeure(Date heure) {
		this.heure = heure;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	
	
}
