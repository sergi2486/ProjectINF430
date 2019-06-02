package com.uy1.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reservation_examens")
public class ReservationExamen implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String faculte;
	private String user;
	private String semestre;
	private String jour;
	private String classe;
	private String ressource;
	private String filiere;
	private String ue;
	private String observation;
	
	@DateTimeFormat(pattern="HH:mm")
	private Date heure_deb;
	@DateTimeFormat(pattern="HH:mm")
	private Date heure_fin;
	
	public ReservationExamen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ReservationExamen(String faculte, String user, String semestre, String jour, String classe, String ressource,
			String filiere, String ue, Date heure_deb, Date heure_fin) {
		super();
		this.faculte = faculte;
		this.user = user;
		this.semestre = semestre;
		this.jour = jour;
		this.classe = classe;
		this.ressource = ressource;
		this.filiere = filiere;
		this.ue = ue;
		this.heure_deb = heure_deb;
		this.heure_fin = heure_fin;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFaculte() {
		return faculte;
	}

	public void setFaculte(String faculte) {
		this.faculte = faculte;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getRessource() {
		return ressource;
	}

	public void setRessource(String ressource) {
		this.ressource = ressource;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getUe() {
		return ue;
	}

	public void setUe(String ue) {
		this.ue = ue;
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
