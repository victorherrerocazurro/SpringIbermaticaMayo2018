package com.ejemplo.spring.data.rest.services;

import com.ejemplo.spring.data.rest.entities.Factura;

public interface Servicio {

	Factura nuevo(Factura factura);

	Iterable<Factura> buscar();

	Iterable<Factura> buscarPorConcepto(String concepto);
	
}