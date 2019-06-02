package com.uy1.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="type_ressources")
public class TypeRessource implements Serializable {

	
	@Id
	@NotNull(message="Ce champ est obligatoire")
	@Size(min=3, max=50)
	private String nom;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@OneToMany(mappedBy="type_ressource")
	Collection<Ressource> ressources;

	public TypeRessource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeRessource(String nom, Date date) {
		super();
		this.nom = nom;
		this.date = date;
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

	public Collection<Ressource> getRessources() {
		return ressources;
	}

	public void setRessources(Collection<Ressource> ressources) {
		this.ressources = ressources;
	}


	
	
}
