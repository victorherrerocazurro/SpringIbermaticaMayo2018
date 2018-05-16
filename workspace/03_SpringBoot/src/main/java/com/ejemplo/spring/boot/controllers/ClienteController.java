package com.ejemplo.spring.boot.controllers;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.spring.boot.dto.Factura;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {

	@GetMapping(path="/{id}/Facturas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Factura> consultarFacturasDeUnCliente(
									@PathVariable long id,
									@RequestParam(name="from", defaultValue="0") int desde, 
									@RequestParam(name="num", defaultValue="10") int numeroElementos) {
		return Arrays.nonNullElementsIn(new Factura[] {new Factura(1, "mi factura")});
	}
	
}
