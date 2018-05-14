package es.curso.spring.basico.persistence;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

@Repository("persistenciaMemoria")
public class PersistenciaMemoria implements Persistencia {

	@Autowired
	private MessageSource messageSource;
	
	public String obtenerSaludo() {
		return messageSource.getMessage("saludo", new Object[]{}, Locale.ENGLISH);
	}

}
