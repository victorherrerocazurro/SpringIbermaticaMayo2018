package com.ejemplo.spring;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aplicacion {

	private static Logger _log = Logger.getLogger(Aplicacion.class.getName());
	
	public static void main(String[] args) throws InterruptedException {
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				Configuracion.class);
		
		//Obtenemos un Bean por Tipo
		ServicioFecha servicio = context.getBean(ServicioFecha.class);
		
		_log.info("OK _ FECHA OBTENIDA: " + servicio.getFecha().toString());
		
		Thread.sleep(2000);
		
		_log.info("NOK _ FECHA OBTENIDA: " + servicio.getFecha().toString());
		
		servicio.resetear();
		
		_log.info("OK _ FECHA OBTENIDA: " + servicio.getFecha().toString());
		
		Thread.sleep(2000);
		
		_log.info("NOK _ FECHA OBTENIDA: " + servicio.getFecha().toString());
		
		servicio.actualizar();
		
		_log.info("OK _ FECHA OBTENIDA: " + servicio.getFecha().toString());
		
	}

}
