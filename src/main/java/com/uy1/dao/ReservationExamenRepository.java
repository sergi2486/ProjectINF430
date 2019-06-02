package com.uy1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uy1.Entities.ReservationExamen;

public interface ReservationExamenRepository extends JpaRepository<ReservationExamen, Long> {

	//@Query("select r from ReservaionExamen")
	//public List<ReservationExamen> listeReservationExamen();
	
	
}
