package com.ejemplo.spring.data.rest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.ejemplo.spring.data.rest.entities.Factura;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Import(ConfiguracionTest.class)
@EnableJpaRepositories
//@WebMvcTest(FacturaController.class)
public class ServiceHumoTest {

	//Al no definir la anotacion @DataJpaTest, no se crea eñ
	//TestEntityManager
	//@Autowired
	//TestEntityManager entityManager;
	
	@LocalServerPort
    private int port;

	//@Autowired
	//MockMvc mock;
	@Autowired
	private TestRestTemplate template;
	
	@Test
	public void consultarPorIdTest() throws Exception {
		
		//Al no hacer la insercion previa con el EntityManager, no hay registro, retorna (0,null)
		Factura factura = new Factura(0, null);
		
		//Ejecutar el codigo a probar

		//mock.perform(get("/Facturas/{id}", 1)).andExpect(status().is(200));
		Factura resultadoObtenido = template.getForEntity("/example", Factura.class).getBody();

		System.out.println(resultadoObtenido);
		
		//resuladoObtenido es unicamente dependiente de nuestro algoritmo
		
		//En caso de que el SUT probado no retorne resultado, la alternativa para la validacion
		//es comprobar el estado en el que queda el entorno
		//Factura resultadoObtenido = entityManager.find(Factura.class, factura.getId());
		
		//Validar
		assertEquals(factura.getId(), resultadoObtenido.getId());
		
		
		
	}

}
