package com.ejemplo.spring.data.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.spring.data.rest.entities.Factura;
import com.ejemplo.spring.data.rest.persistence.FacturaRepository;

@Service
public class BasicService implements Servicio {

	@Autowired
	private FacturaRepository dao;
	
	/* (non-Javadoc)
	 * @see com.ejemplo.spring.data.jdbc.services.Servicio#nuevo(com.ejemplo.spring.data.jdbc.entities.Factura)
	 */
	public Factura nuevo(Factura factura){
		Factura facturaGuardada = dao.save(factura);
		System.out.println("GUARDADA: " + facturaGuardada);
		return facturaGuardada;
	}
	
	/* (non-Javadoc)
	 * @see com.ejemplo.spring.data.jdbc.services.Servicio#buscar()
	 */
	public Iterable<Factura> buscar(){
		return dao.findAll();
	}

	@Override
	public Iterable<Factura> buscarPorConcepto(String concepto) {
		return dao.findByConcepto(concepto);
	}
	
}
