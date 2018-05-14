package com.ejemplo;

public class FalsoContextoDeSpring {

	//Son los Beans del contexto
	private TargetImpl target = new TargetImpl();
	
	//Todos los beans que manejamos son proxeados
	private Proxy proxy = new Proxy(target);
	
	public Target getTarget() {
		return target;
	}

}
