package com.uy1.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation_autres")
public class ReservationAutre implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	private String ressource;
	private String raison;
	
	private Date heure_deb;
	private Date heure_fin;
	public ReservationAutre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservationAutre(String ressource, String raison, Date heure_deb, Date heure_fin) {
		super();
		this.ressource = ressource;
		this.raison = raison;
		this.heure_deb = heure_deb;
		this.heure_fin = heure_fin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRessource() {
		return ressource;
	}
	public void setRessource(String ressource) {
		this.ressource = ressource;
	}
	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}
	public Date getHeure_deb() {
		return heure_deb;
	}
	public void setHeure_deb(Date heure_deb) {
		this.heure_deb = heure_deb;
	}
	public Date getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(Date heure_fin) {
		this.heure_fin = heure_fin;
	}
	
	
}
