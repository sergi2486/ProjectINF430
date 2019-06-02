package com.uy1.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uy1.Entities.Ressource;
import com.uy1.Entities.TypeRessource;
import com.uy1.dao.RessourceRepository;
import com.uy1.dao.TypeRessourceRepository;

@RestController
public class ControleurRessource {
	
	@Autowired
	private RessourceRepository ressourceRepository;
	
	
	
	@RequestMapping(value="/ressources", method=RequestMethod.POST)
	@Secured(value= {"ROLE_ADMIN"})
	public Object saveRessource(@RequestBody @Valid Ressource ressource, BindingResult bindingResult) {  // requestbody pour indiquer que les données seront envoyées en format JSON
		// @valide c'est la validation par spring mvc
		
		if(bindingResult.hasErrors()) {
			System.out.println("erreur");
			Map<String, Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()) {
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors;
		}
		return ressourceRepository.save(ressource);
	}
	
	@RequestMapping(value="/ressources", method=RequestMethod.GET)
	@Secured(value= {"ROLE_ADMIN"})
	public List<Ressource> listeRessources() { 
		return ressourceRepository.findAll(new Sort(Sort.Direction.ASC, "nom"));
	}
	

}
