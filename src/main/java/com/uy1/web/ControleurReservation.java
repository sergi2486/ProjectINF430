package com.uy1.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uy1.Entities.Reservation;
import com.uy1.Entities.TypeReservation;
import com.uy1.dao.ReservationRepository;
import com.uy1.dao.TypeReservationRepository;


@RestController
public class ControleurReservation {

	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private TypeReservationRepository typeReservationRepository;
	
	
	
	@RequestMapping(value="/reservations", method=RequestMethod.POST)
	@Secured(value= {"ROLE_ADMIN"})
	public Object saveReservation(@RequestBody @Valid Reservation reservation, BindingResult bindingResult) {  // requestbody pour indiquer que les données seront envoyées en format JSON
		// @valide c'est la validation par spring mvc
		
		if(bindingResult.hasErrors()) {
			System.out.println("erreur !");
			Map<String, Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()) {
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors;
		}
		return reservationRepository.save(reservation);
	}
	
	@RequestMapping(value="/reservations", method=RequestMethod.GET)
	@Secured(value= {"ROLE_ADMIN"})
	public List<Reservation> listeReservation() {
		String mc;
		return reservationRepository.listeReservation("inf-l1", "lundi");
	}
	
	@RequestMapping(value="/typeReservations",  method=RequestMethod.GET)
	@Secured(value= {"ROLE_ADMIN"})
	public List<TypeReservation> listeTypeReservation(){
		
		return typeReservationRepository.findAll();
	}
	
	
}
