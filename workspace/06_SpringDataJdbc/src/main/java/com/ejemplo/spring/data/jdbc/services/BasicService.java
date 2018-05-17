package com.ejemplo.spring.data.jdbc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.spring.data.jdbc.entities.Factura;
import com.ejemplo.spring.data.jdbc.persistence.FacturaDao;

@Service
@Transactional
public class BasicService implements Servicio {

	@Autowired
	private NamedParameterJdbcOperations jdbcTemplate;
	
	@Autowired
	private FacturaDao dao;
	
	/* (non-Javadoc)
	 * @see com.ejemplo.spring.data.jdbc.services.Servicio#nuevo(com.ejemplo.spring.data.jdbc.entities.Factura)
	 */
	public void nuevo(Factura factura){
		boolean facturaGuardada = dao.insert(factura.getId(), factura.getConcepto());
		//Factura facturaGuardada = dao.save(factura);
		System.out.println("GUARDADA: " + facturaGuardada);
	}
	
	/* (non-Javadoc)
	 * @see com.ejemplo.spring.data.jdbc.services.Servicio#buscar()
	 */
	@Transactional(readOnly=true)
	public Iterable<Factura> buscar(){
		return dao.findAll();
	}

	@Override
	public Iterable<Factura> buscarPorConcepto(String concepto) {
		return dao.findByConcepto(concepto);
	}
	
}
