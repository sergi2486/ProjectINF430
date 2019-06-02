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


import com.uy1.Entities.UE;

import com.uy1.dao.UERepository;

@RestController
public class ControleurUE {

	@Autowired
	private UERepository ueRepository;
	
	@RequestMapping(value="/ues", method=RequestMethod.POST)
	@Secured(value= {"ROLE_ADMIN"})
	public Object saveUE(@RequestBody @Valid UE ue, BindingResult bindingResult) {  // requestbody pour indiquer que les données seront envoyées en format JSON
		// @valide c'est la validation par spring mvc
		
		if(bindingResult.hasErrors()) {
			
			Map<String, Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()) {
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors;
		}
		return ueRepository.save(ue);
	}
	
	@RequestMapping(value="/ues", method=RequestMethod.GET)
	@Secured(value= {"ROLE_ADMIN"})
	public List<UE> listeUE() {
		
		return ueRepository.findAll();
	}
}
