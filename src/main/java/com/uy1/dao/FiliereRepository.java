package com.uy1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uy1.Entities.Filiere;

public interface FiliereRepository extends JpaRepository<Filiere, String> {

//	@Query("select f from Filiere f order by id desc")
//	public List<Filiere> listeFilieres();
}
