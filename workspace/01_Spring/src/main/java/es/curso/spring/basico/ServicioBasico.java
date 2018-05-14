package es.curso.spring.basico;

public class ServicioBasico implements Servicio {

	//Acoplamiento
	//private Persistencia persistencia = new PersistenciaMemoria();
	
	private Persistencia persistencia;
	
	//Inyeccion por contruccion, cuando la dependencia es obligatoria
	
	public ServicioBasico(Persistencia persistencia) {
		super();
		this.persistencia = persistencia;
	}
	
	//Inyeccion por Setter, pues cuando no sea obligatorio
	
	public void setPersistencia(Persistencia persistencia) {
		this.persistencia = persistencia;
	}
	
	public void saludar() {

		String saludo = persistencia.obtenerSaludo();
		
		System.out.println(saludo);		

	}
}
