package com.uy1.dao;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uy1.Entities.Faculte;

public interface FaculteRepository extends JpaRepository<Faculte, String> {
	
	@Query("select f from Faculte f order by id desc")
	public List<Faculte> listeFacultes();
	
	@Modifying
	@Query(value = "insert into facultes(nom, date) values(?1, NOW())", nativeQuery = true)
	public int insererFaculte(@Param("nom") String nom, @Param("date") String date);
}
