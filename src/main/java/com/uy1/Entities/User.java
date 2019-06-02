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
@Table(name="users")
public class User implements Serializable {

	
	@Id
	@NotNull(message="Ce champ est obligatoire")
	@Size(min=2, max=30)
	private String username;
	@NotNull(message="Ce champ est obligatoire")
	@Size(min=2, max=30)
	private String password;
	private boolean actived;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	
	@ManyToMany
	@JoinTable(name="user_role", joinColumns=
	@JoinColumn(name="id_user"), inverseJoinColumns=
	@JoinColumn(name="id_role"))
	private Collection<Role> roles;
	
	@ManyToMany
	@JoinTable(name="user_reservation", joinColumns=
	@JoinColumn(name="id_user"), inverseJoinColumns=
	@JoinColumn(name="id_reservation"))
	private Collection<Reservation> reservations;
	
	@OneToMany(mappedBy="user")
	private Collection<Ressource> ressources;
	
//	@ManyToOne
//	@JoinColumn(name="id_filiere")
	private String filiere;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, Date date, String filiere) {
		super();
		this.username = username;
		this.password = password;
		//this.actived = actived;
		this.date = date;
		//this.roles = roles;
		//this.reservations = reservations;
		this.filiere = filiere;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Collection<Ressource> getRessources() {
		return ressources;
	}

	public void setRessources(Collection<Ressource> ressources) {
		this.ressources = ressources;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

}
