package com.ejemplo.spring.security;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ConfiguracionSeguridad  extends WebSecurityConfigurerAdapter{
	
	@Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(passwordEncoder());
    }

	@Bean
	public PasswordEncoder passwordEncoder() {		
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//.authorizeRequests().antMatchers("/holamundo/**").hasAnyRole("READER")
			.authorizeRequests().antMatchers("/holamundo/**").access("hasAnyRole('READER')")
				.and()
			.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		http.formLogin()
        		.loginPage("/login")
        		.permitAll();
		
		http.csrf().ignoringAntMatchers("/login", "/logout");
		
		http.logout()
				.logoutSuccessUrl("/")
				.permitAll();
		
		http.addFilterBefore(miFiltroDeSeguridad(), AnonymousAuthenticationFilter.class);
		
	}

	@Bean
	public Filter miFiltroDeSeguridad() {
		return new MiFiltroDeSeguridad();
	}
	
}
