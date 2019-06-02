package com.uy1.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uy1.Entities.TypeRessource;
import com.uy1.dao.TypeRessourceRepository;

@RestController
public class ControleurTypeRessource {
	
	@Autowired
	private TypeRessourceRepository typeRessourceRepository;
	
	@RequestMapping(value="/typeRessources", method=RequestMethod.POST)
	public Object saveTypeRessource(@RequestBody @Valid TypeRessource type, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			Map<String, Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()) {
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors;
		}
		
		return typeRessourceRepository.save(type);
		
	}
	
	@RequestMapping(value="/typeRessources", method=RequestMethod.GET)
	public List<TypeRessource> listeTypesRessources(){
		System.out.println("kdjfkj");
		return typeRessourceRepository.listeTypeTes();
		
	}

}
