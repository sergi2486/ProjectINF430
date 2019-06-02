package com.uy1.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="roles")
public class Role implements Serializable {
	
	
	@Id
	@NotNull(message="Ce champ est obligatoire !")
	@Size(min=2, max=20)
	private String nom;
	private Date date;
	
	@ManyToMany(mappedBy="roles")
	private Collection<User> users;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String nom, String description, Date date) {
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

	public Collection<User> getUser() {
		return users;
	}

	public void setUser(Collection<User> users) {
		this.users = users;
	}
	
	

}
