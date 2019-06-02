package com.uy1;

import javax.annotation.security.PermitAll;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true) // pour prendre en compte les roles en protégeant les méthodes et l'activer
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// création d'une méthode de configuration globale
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN", "PROF");
//		auth.inMemoryAuthentication().withUser("prof").password("{noop}prof").roles("PROF");
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal, password as credentials, true from users where username = ?")
			.authoritiesByUsernameQuery("select id_user as principal, id_role as role from user_role where id_user = ?")
			.rolePrefix("ROLE_");
			
	}
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		// design pattern builder
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/bootstrap/**", "/js/**", "/img/** ").permitAll()
				.anyRequest()
					.authenticated()
						.and()
			.formLogin()
				.loginPage("/login").loginPage("/visiteur")
				.permitAll()
			.defaultSuccessUrl("/index.html")
			.failureUrl("/error.html");
	}
}
