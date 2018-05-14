package es.curso.spring.basico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionSpring {

	//Es que el nombre tenga un aspecto de Identificador, o si quereis de nombre de variable
	@Bean
	//Es Singleton desde el contexto de spring
	//@Scope(scopeName="prototype")
	//Con autowired, presentamos Beans de Spring
	@Autowired
	public Servicio servicio(Persistencia persistencia){
		//En este caso ServicBasico si es Bean de Spring y PersistenciaMemoria no lo es
		//return new ServicioBasico(new PersistenciaMemoria());
		
		return new ServicioBasico(persistencia);
	}
	
	@Bean
	public Persistencia persistencia(){
		return new PersistenciaMemoria();
	}
	
}
