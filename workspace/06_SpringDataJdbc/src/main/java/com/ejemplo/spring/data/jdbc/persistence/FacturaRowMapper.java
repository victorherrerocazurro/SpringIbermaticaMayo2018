package com.ejemplo.spring.data.jdbc.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ejemplo.spring.data.jdbc.entities.Factura;

public class FacturaRowMapper implements RowMapper<Factura> {
	public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Factura(rs.getLong("id"), rs.getString("concepto"));
	}
}
