package com.ejemplo;

//Aspecto
public class Proxy implements Target {

	private Target target;
	
	public Proxy(Target target) {
		super();
		this.target = target;
	}

	@Override
	public void hazAlgo() {
		System.out.println("En el Proxy: Antes");
		//Decide segun la configuracion
		if(true){
			target.hazAlgo();
		}
		System.out.println("En el Proxy: Despues");
	}

}
