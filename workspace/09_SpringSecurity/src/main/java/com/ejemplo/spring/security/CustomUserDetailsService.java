package com.ejemplo.spring.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomUserDetailsService implements UserDetailsService {

	private PasswordEncoder passwordEncoder;

	public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Consulta a mi entorno de persistencia para obtener los datos del
		// username

		if (username.equals("user")) {
			return User.withUsername(username).password(passwordEncoder.encode("password")).roles("READER", "ADMIN")
					.build();
		} else {
			throw new UsernameNotFoundException("No se encuentra el usuario");
		}
	}

}
