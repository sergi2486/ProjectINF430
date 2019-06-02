package com.uy1.web;

import java.util.HashMap;
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

import com.uy1.Entities.Historique;
import com.uy1.Entities.Reservation;
import com.uy1.dao.HistoriqueRepository;

@RestController
public class ControleurHistorique {

	@Autowired
	private HistoriqueRepository historiqueRepository;
	
	@RequestMapping(value="/historiques", method=RequestMethod.POST)
	@Secured(value= {"ROLE_ADMIN"})
	public Historique saveReservation(Historique historique) {  // requestbody pour indiquer que les données seront envoyées en format JSON
		// @valide c'est la validation par spring mvc
		
		
		return historiqueRepository.save(historique);
	}
	
	@RequestMapping(value="/historiques")
	@Secured(value= {"ROLE_ADMIN"})
	public void  saveHistorique(Historique historique) {
		historiqueRepository.save(historique);
	}
}
