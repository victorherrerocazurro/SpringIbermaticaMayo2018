package com.ejemplo.spring.data.jdbc.services;

import java.util.List;

import com.ejemplo.spring.data.jdbc.entities.Factura;

public interface Servicio {

	void nuevo(Factura factura);

	Iterable<Factura> buscar();

	Iterable<Factura> buscarPorConcepto(String concepto);
	
}