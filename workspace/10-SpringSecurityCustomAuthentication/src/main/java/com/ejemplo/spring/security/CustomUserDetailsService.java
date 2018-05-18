package com.ejemplo.spring.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomUserDetailsService implements UserDetailsService {

	private PasswordEncoder passwordEncoder;
	
	public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username.equals("user")) {
			
			return User
					.withUsername(username)
					.password(passwordEncoder.encode("user"))
					.roles("ADMIN", "READER").build();
		} else {
			throw new UsernameNotFoundException("Usuario no valido");
		}
	}

}
