package com.ejemplo.spring.data.jdbc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.spring.data.jdbc.entities.Factura;
import com.ejemplo.spring.data.jdbc.persistence.FacturaDao;

@Service
@Transactional
public class BasicService implements Servicio {

	@Autowired
	private FacturaDao dao;
	
	/* (non-Javadoc)
	 * @see com.ejemplo.spring.data.jdbc.services.Servicio#nuevo(com.ejemplo.spring.data.jdbc.entities.Factura)
	 */
	public void nuevo(Factura factura){
		dao.save(factura);
	}
	
	/* (non-Javadoc)
	 * @see com.ejemplo.spring.data.jdbc.services.Servicio#buscar()
	 */
	public List<Factura> buscar(){
		return dao.findAll();
	}
	
}
