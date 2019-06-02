package com.uy1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uy1.Entities.TypeRessource;

public interface TypeRessourceRepository extends JpaRepository<TypeRessource, Long> {

	@Query("select t from TypeRessource t order by id desc")
	public List<TypeRessource> listeTypeTes();
}
