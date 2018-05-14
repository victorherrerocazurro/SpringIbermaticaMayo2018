package es.curso.spring.basico.config.anotations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan({
		"es.curso.spring.basico.persistence",
		"es.curso.spring.basico.servicios",
		"es.curso.spring.basico.eventos"
})
@PropertySource("classpath:db.properties")
//@Profile("anotaciones")
public class ConfiguracionSpringAnotaciones {
	
	@Value("${jdbc.url}")
	private String connection;
	
	@Bean
	//@Profile("anotaciones")
	public MessageSource messageSource(){
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		
		resourceBundleMessageSource.setBasename("mensajes");
		
		return resourceBundleMessageSource;
	}
	
	@Bean
	public DataSource dataSource(
			@Value("${jdbc.url}") String connection, 
			@Value("${jdbc.user}") String user, 
			@Value("${jdbc.password}") String password){
		return null;
	}
	
	
	
}
