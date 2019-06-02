package com.uy1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uy1.Entities.Ressource;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {

	@Query("select r from Ressource r order by id desc")
	public List<Ressource> listeRessources();
	
//	@Query("select r from Ressource r where r.nom like :x or r.type_ressource like :x")
//	public List<Ressource> chercherRessource(@Param("x") String mc);
}
