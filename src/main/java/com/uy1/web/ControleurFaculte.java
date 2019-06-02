package com.uy1.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uy1.Entities.Faculte;

import com.uy1.dao.FaculteRepository;

@RestController
public class ControleurFaculte {

	@Autowired
	private FaculteRepository faculteRepository;
	
	
	@RequestMapping(value="/facultes", method=RequestMethod.POST)
	@Secured(value= {"ROLE_ADMIN"})
	public Object saveFaculte(@RequestBody @Valid Faculte faculte, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			Map<String, Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()) {
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors;
		}
		Date d = new Date();
		DateFormat shortDateFormatEN = DateFormat.getDateTimeInstance(
				DateFormat.MEDIUM,
				DateFormat.MEDIUM, new Locale("FR","fr"));
		System.out.println(shortDateFormatEN.format(d));
		//return faculteRepository.insererFaculte("nom", shortDateFormatEN.format(d));
		return faculteRepository.save(faculte);
	}
	
	@RequestMapping(value="/facultes", method=RequestMethod.GET)
	@Secured(value= {"ROLE_ADMIN"})
	public List<Faculte> listeFacultes() {
		
		return faculteRepository.findAll(new Sort(Sort.Direction.ASC, "nom"));
	}
}
