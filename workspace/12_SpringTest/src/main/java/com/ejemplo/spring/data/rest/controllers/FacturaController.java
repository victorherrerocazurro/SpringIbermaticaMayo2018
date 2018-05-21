package com.ejemplo.spring.data.rest.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.spring.data.rest.entities.Factura;

//RestWebService
//@RestController
//@RequestMapping("/Facturas")
public class FacturaController {
	
	// 2-APIs REST o JSON
	
	//Facturas/1
	
	//Facturas/uno - No Valido, no es Long
	
	// La cabecera Accept permite al cliente, definir el tipo de representacion
	// del dato que acepta
	// como respuesta, (*/*, application/json, application/xml, text/plain, .../png)
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	//Esta anotacion es necesaria para retornar objetos complejos en una clase @Controller,
	//Pero no es necesaria si la clase es @RestController
	//@ResponseBody
	public Factura consultar(@PathVariable long id) {
		return new Factura(id, "mi factura");
	}
	
	//Con @RequestParam, se permite definr clausulas Where, filtros
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Factura> consultar(
									@RequestParam(name="from", defaultValue="0") int desde, 
									@RequestParam(name="num", defaultValue="10") int numeroElementos) {
		return Arrays.asList(new Factura[] {new Factura(1, "mi factura")});
	}
	
	// La cabecera Content-Type, permite que el cliente le diga al servicio el formato en el que envia 
	// la informacion
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	//Nos llegaria toda la informacion menos el Id
	public ResponseEntity<Void> insertar(@RequestBody Factura factura) throws URISyntaxException{
		System.out.println(factura);
		long id = 1; //Resultado de la invocacion del servicio
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(new URI("http://localhost:8080/Facturas/" + id));
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	//Nos llegaria toda la informacion incluido el Id
	public void modificar(@RequestBody Factura factura) throws URISyntaxException{
		System.out.println(factura);
	}
	
	@DeleteMapping(path="/{id}")
	public void borrar(@PathVariable long id) {
		System.out.println("Se esta borrando el registro con Id: " + id);
	}
	
}
