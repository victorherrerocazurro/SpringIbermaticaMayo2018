package com.ejemplo.spring.jdbc.persistencia;

import java.util.List;

import com.ejemplo.spring.jdbc.entities.Factura;

public interface FacturaDao {

	//La referencia a un objeto que permita ejecutar consultas JDBC, sin mucha complicacion
	long insertar(Factura factura);

	List<Factura> consultatodo();

	Factura consultaPorId(long id);

}