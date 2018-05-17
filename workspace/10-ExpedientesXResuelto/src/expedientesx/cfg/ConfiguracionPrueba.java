package expedientesx.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ConfiguracionPrueba {
	@Autowired
	public void otro(){
		System.out.println("***************** En Otro *****************");
	}
}
