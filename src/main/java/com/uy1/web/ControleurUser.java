package com.uy1.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uy1.Entities.Filiere;
import com.uy1.Entities.Role;
import com.uy1.Entities.User;
import com.uy1.dao.RoleRepository;
import com.uy1.dao.UserRepository;

@RestController
public class ControleurUser {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value="/getLogedUser")
	public Map<String, Object> getLogedUser(HttpServletRequest httpServletRequest){
		
		HttpSession httpSession = httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		
		String username = securityContext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for(GrantedAuthority ga: securityContext.getAuthentication().getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
		
		return params;
	}
	
	// gestion des utilisateurs internes
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public Object saveUser(@RequestBody @Valid User user, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("erreur !!!");
			Map<String, Object> errors = new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe: bindingResult.getFieldErrors()) {
				errors.put(fe.getField(), fe.getDefaultMessage());
			}
			return errors;
		}
		return userRepository.save(user);
	}
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> listeUser() {
		
		return userRepository.findAll();
	}
	
	// gestion des rôles
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/saveRole", method=RequestMethod.POST)
	public Role saveUser(@RequestBody Role role) { // requestbody pour les données en JSON
		
		return roleRepository.save(role);
	}	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/listeRoles")
	public List<Role> listeRoles() {
		
		return roleRepository.findAll();
	}
	
	// affecter un role à un utilisateur
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/addRoleToUser")
	public User addRoleToUser(String username, String role) {
		
		User u = userRepository.getOne(username);
		Role r = roleRepository.getOne(role);
		u.getRoles().add(r);
		userRepository.save(u); 
		return u;
		
	}
}
