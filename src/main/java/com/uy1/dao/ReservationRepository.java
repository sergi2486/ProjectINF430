package com.uy1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uy1.Entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("select r from Reservation r where (r.classe like :x and r.jour like :y) or (r.classe like :x and r.jour like :y)")
	public List<Reservation> listeReservation(@Param("x") String x, @Param("y") String y);
}
