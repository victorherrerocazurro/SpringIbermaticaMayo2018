package com.ejemplo.spring.data.rest;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.ejemplo.spring.data.rest.services.BasicService;

@TestConfiguration
public class ConfiguracionTest {

	@Bean
	public BasicService basicService(){
		return new BasicService();
	}
	
}
