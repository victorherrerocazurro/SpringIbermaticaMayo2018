package com.ejemplo;

//El elemento que quiere acceder al Target
public class Cliente {

	public static void main(String[] args) {
		
		FalsoContextoDeSpring contexto = new FalsoContextoDeSpring();
		
		Target target = contexto.getTarget();
		
		target.hazAlgo();
		
	}
	
}
