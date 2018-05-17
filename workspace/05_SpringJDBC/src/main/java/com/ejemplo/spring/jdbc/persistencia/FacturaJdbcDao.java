package com.ejemplo.spring.jdbc.persistencia;

import java.sql.SQLType;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ejemplo.spring.jdbc.entities.Factura;

@Repository
public class FacturaJdbcDao extends JdbcDaoSupport implements FacturaDao{

	@Autowired
	public FacturaJdbcDao(JdbcTemplate jdbcTemplate) {
		super();
		setJdbcTemplate(jdbcTemplate);
	}

	private static final String INSERT_FACTURAS = "INSERT INTO Facturas (concepto) VALUES (?)";
	private static final String CONSULTA_FACTURA_POR_ID = "SELECT id, concepto FROM Facturas WHERE id = ?";
	private static final String CONSULTA_FACTURA_TODAS = "SELECT id, concepto FROM Facturas";

	//La referencia a un objeto que permita ejecutar consultas JDBC, sin mucha complicacion
	/* (non-Javadoc)
	 * @see com.ejemplo.spring.jdbc.persistencia.FacturaDao#insertar(com.ejemplo.spring.jdbc.persistencia.Factura)
	 */
	public long insertar(Factura factura){
		
		//Consulta simplificada , sin necesidad de obtener el retorno de la clave genrada
		//getJdbcTemplate().update(INSERT_FACTURAS, factura.getId(), factura.getConcepto());
		
		//Consulta obteniendo la clave generada por la BD
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
															INSERT_FACTURAS, Types.VARCHAR);
		
		pscf.setReturnGeneratedKeys(true);
		
		PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
				new Object[]{factura.getConcepto()});
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		getJdbcTemplate().update(psc, keyHolder);
		
		return keyHolder.getKey().longValue();
	}
	
	public Factura consultaPorId(long id){
		
		Factura factura = getJdbcTemplate().queryForObject(CONSULTA_FACTURA_POR_ID, new Object[]{id}, new FacturaRowMapper());
		
		return factura;
	}
	
	public List<Factura> consultatodo(){
		
		List<Factura> facturas = getJdbcTemplate().query(CONSULTA_FACTURA_TODAS, new Object[]{}, new FacturaRowMapper());
		
		return facturas;
	}
	
}
