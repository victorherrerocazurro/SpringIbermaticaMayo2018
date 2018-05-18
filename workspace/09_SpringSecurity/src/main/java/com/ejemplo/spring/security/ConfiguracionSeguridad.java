package com.ejemplo.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ConfiguracionSeguridad  extends WebSecurityConfigurerAdapter{

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
			.withUser("admin").password("$2a$10$SMPYtil7Hs2.cV7nrMjrM.dRAkuoLdYM8NdVrF.GeHfs/MrzcQ/zi").roles("ADMIN","READER").disabled(false)
				.and()
			.withUser("user").password("$2a$10$SMPYtil7Hs2.cV7nrMjrM.dRAkuoLdYM8NdVrF.GeHfs/MrzcQ/zi").roles("READER").disabled(false);
	}*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
    @Override
    public UserDetailsService userDetailsService() {
        /*UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("READER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);*/
		return new CustomUserDetailsService(passwordEncoder());
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//.authorizeRequests().antMatchers("/holamundo/**").hasAnyRole("READER")
			.authorizeRequests().antMatchers("/holamundo/**").access("hasAnyRole('READER')")
				.and()
			.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		//http.httpBasic();
		
		http.formLogin()
        		.loginPage("/login")
        		.permitAll();
		
		http.csrf().ignoringAntMatchers("/login", "/logout");
		
		http.logout()
				.logoutSuccessUrl("/")
				.permitAll();
	
		http.addFilterBefore(customAuthenticationProcessingFilter(), AnonymousAuthenticationFilter.class);
		
	}

	@Bean
	public CustomAuthenticationProcessingFilter customAuthenticationProcessingFilter() {
		return new CustomAuthenticationProcessingFilter();
	}
	
}
