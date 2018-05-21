package com.ejemplo.spring.data.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ejemplo.spring.data.rest.entities.Factura;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")

public class ServiceHumoTest {
	
	@Autowired
	MockMvc mock;
	
	@Test
	public void consultarPorIdTest() throws Exception {
		
		Factura factura = new Factura(0, null);
		
		ObjectMapper mapper = new ObjectMapper();
        byte[] facturaAsBytes = mapper.writeValueAsBytes(factura);

		//Ejecutar el codigo a probar, junto con las validaciones
		mock
			.perform(post("/clientes").content(facturaAsBytes).contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().is(201));

		mock.perform(get("/clientes/0")).andExpect(status().is(200));
	}

}
