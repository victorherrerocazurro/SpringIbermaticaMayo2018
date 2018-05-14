package es.curso.spring.basico;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aplicacion {

	public static void main(String[] args) {
	
		//Este objeto permite interaccionar con Spring
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
															Aplicacion.class.getPackage().getName());
		
		//Obtenemos un Bean por Tipo
		Servicio servicio = context.getBean(Servicio.class);
		
		//Obtenemos un bean por identificador
		Servicio servicio1 = context.getBean("servicio", Servicio.class);
		
		//Servicio servicio2 = new ServicioBasico();
		
		servicio.saludar();
		
		servicio1.saludar();
		

	}

}
