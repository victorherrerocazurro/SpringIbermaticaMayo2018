package es.curso.spring.basico.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import es.curso.spring.basico.persistence.Persistencia;

@Service("servicio")
public class ServicioBasico implements Servicio {

	//Acoplamiento
	//private Persistencia persistencia = new PersistenciaMemoria();
	//@Autowired
	private Persistencia persistencia;
	
	//Inyeccion por contruccion, cuando la dependencia es obligatoria
	@Autowired
	public ServicioBasico(@Qualifier("persistenciaMemoria") Persistencia persistencia) {
		super();
		this.persistencia = persistencia;
	}
	
	//Inyeccion por Setter, pues cuando no sea obligatorio
	//@Autowired
	public void setPersistencia(Persistencia persistencia) {
		this.persistencia = persistencia;
	}
	
	public void saludar() {

		String saludo = persistencia.obtenerSaludo();
		
		System.out.println(saludo);		

	}
}
