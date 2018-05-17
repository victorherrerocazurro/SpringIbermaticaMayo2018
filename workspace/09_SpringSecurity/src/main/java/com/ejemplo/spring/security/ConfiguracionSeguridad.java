package com.ejemplo.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ConfiguracionSeguridad  extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ADMIN","READER").disabled(false)
				.and()
			.withUser("user").password("user").roles("READER").disabled(false);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/holamundo/**").hasAnyRole("READER")
				.and()
			.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
	}
	
}
