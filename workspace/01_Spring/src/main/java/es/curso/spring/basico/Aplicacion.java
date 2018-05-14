package es.curso.spring.basico;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.spring.basico.config.anotations.ConfiguracionSpringAnotaciones;
import es.curso.spring.basico.eventos.MiEvento;
import es.curso.spring.basico.servicios.Servicio;

public class Aplicacion {

	public static void main(String[] args) {
	
		//Este objeto permite interaccionar con Spring
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
		//													Aplicacion.class.getPackage().getName());
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ConfiguracionSpringAnotaciones.class);
		
		//Obtenemos un Bean por Tipo
		Servicio servicio = context.getBean(Servicio.class);
		
		//Obtenemos un bean por identificador
		Servicio servicio1 = context.getBean("servicio", Servicio.class);
		
		//Servicio servicio2 = new ServicioBasico();
		
		servicio.saludar();
		
		servicio1.saludar();
		
		String message = context.getMessage("saludo", new Object[]{}, Locale.ENGLISH);

		context.publishEvent(new MiEvento(message));
		
	}

}
