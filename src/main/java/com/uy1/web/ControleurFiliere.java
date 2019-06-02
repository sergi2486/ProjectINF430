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

import com.uy1.Entities.Filiere;
import com.uy1.dao.FiliereRepository;


@RestController
public class ControleurFiliere {
	
	@Autowired
	private FiliereRepository filiereRepository;
	
	@RequestMapping(value="/filieres", method=RequestMethod.POST)
	@Secured(value= {"ROLE_ADMIN"})
	public Object saveFiliere(@RequestBody @Valid Filiere filiere, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("erreur !!!");
			Map<String, Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()) {
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors;
		}
		return filiereRepository.save(filiere);
	}
	
	@RequestMapping(value="/filieres", method=RequestMethod.GET)
	@Secured(value= {"ROLE_ADMIN"})
	public List<Filiere> listeFiliere() {
		System.out.print("bonjour");
		return filiereRepository.findAll();
	}

}
