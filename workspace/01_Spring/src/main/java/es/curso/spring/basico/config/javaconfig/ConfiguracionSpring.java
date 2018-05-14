package es.curso.spring.basico.config.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.curso.spring.basico.persistence.Persistencia;
import es.curso.spring.basico.persistence.PersistenciaMemoria;
import es.curso.spring.basico.servicios.Servicio;
import es.curso.spring.basico.servicios.ServicioBasico;

@Configuration
public class ConfiguracionSpring {

	//Es que el nombre tenga un aspecto de Identificador, o si quereis de nombre de variable
	@Bean
	//Es Singleton desde el contexto de spring
	//@Scope(scopeName=BeanDefinition.SCOPE_PROTOTYPE)
	//Con autowired, presentamos Beans de Spring
	@Autowired
	public Servicio servicio(@Qualifier("persistencia") Persistencia persistencia){
		//En este caso ServicBasico si es Bean de Spring y PersistenciaMemoria no lo es
		//return new ServicioBasico(new PersistenciaMemoria());
		
		return new ServicioBasico(persistencia);
	}
	
	/*@Bean
	public Servicio servicio(){
		persistencia();
		persistencia();
		return new ServicioBasico(persistencia());
	}*/
	
	@Bean
	//Esto es un singleton
	public Persistencia persistencia(){
		return new PersistenciaMemoria();
	}
	
}
