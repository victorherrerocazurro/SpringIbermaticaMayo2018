package com.ejemplo.spring.data.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ejemplo.spring.data.jdbc.entities.Factura;
import com.ejemplo.spring.data.jdbc.services.Servicio;

public class Aplicacion {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		// Obtenemos un Bean por Tipo
		Servicio servicio = context.getBean(Servicio.class);

		Factura factura1 = new Factura(11, "Compra abrigo");
		servicio.nuevo(factura1);

		Factura factura2 = new Factura(12, "Compra libro");
		servicio.nuevo(factura2);

		Iterable<Factura> facturas = servicio.buscar();

		System.out.println("LISTADO DE FACTURAS RECUPERADAS DE BD:");
		
		for (Factura factura : facturas) {
			System.out.println(factura);
		}
		
		Iterable<Factura> facturasPorConcepto = servicio.buscarPorConcepto("Compra coche");

		System.out.println("LISTADO DE FACTURAS POR CONCEPTO (Compra coche) RECUPERADAS DE BD:");
		
		for (Factura factura : facturasPorConcepto) {
			System.out.println(factura);
		}

	}

}
