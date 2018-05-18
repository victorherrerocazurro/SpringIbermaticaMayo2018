package com.ejemplo.spring.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

public class BasicService {

	@PreAuthorize("hasAnyRole('READER') and #dato == authentication.name")
	//@Secured({"USER", "ADMIN"})
	public void negocio(String dato){
		
	}
	
}
