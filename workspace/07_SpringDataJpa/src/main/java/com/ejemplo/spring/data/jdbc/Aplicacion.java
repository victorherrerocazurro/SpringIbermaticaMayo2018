package com.ejemplo.spring.data.jdbc;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ejemplo.spring.data.jdbc.entities.Factura;
import com.ejemplo.spring.data.jdbc.persistence.FacturaDao;
import com.ejemplo.spring.data.jdbc.services.Servicio;

public class Aplicacion {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		//Obtenemos un Bean por Tipo
		Servicio servicio = context.getBean(Servicio.class);
		
		Factura factura1 = new Factura(1, "Compra coche");
		servicio.nuevo(factura1);
		
		Factura factura2 = new Factura(2, "Compra libro");
		servicio.nuevo(factura2);
		
		Iterable<Factura> facturas = servicio.buscar();
		
		for (Factura factura : facturas) {
			System.out.println(factura);			
		}
		
	}

}
