package com.ejemplo.spring.jdbc.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ejemplo.spring.jdbc.entities.Factura;

public class FacturaRowMapper implements RowMapper<Factura> {
	public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Factura(rs.getLong("id"), rs.getString("concepto"));
	}
}
