package com.ejemplo.spring.jdbc;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ejemplo.spring.jdbc.entities.Factura;
import com.ejemplo.spring.jdbc.persistencia.FacturaDao;

public class Aplicacion {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		//Obtenemos un Bean por Tipo
		FacturaDao dao = context.getBean(FacturaDao.class);
		
		dao.insertar(new Factura(1, "Compra coche"));
		
		dao.insertar(new Factura(2, "Compra libro"));
		
		List<Factura> facturas = dao.consultatodo();
		
		for (Factura factura : facturas) {
			System.out.println(factura);			
		}
		
	}

}
