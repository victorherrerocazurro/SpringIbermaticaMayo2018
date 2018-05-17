package com.ejemplo.spring.data.jdbc.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ejemplo.spring.data.jdbc.entities.Factura;

public interface FacturaDao extends JpaRepository<Factura, Long>{

	List<Factura> findByConcepto(String concepto);
	
	@Query(value="select f from Factura f where f.concepto = :concepto")
	List<Factura> consultarPorConcepto(@Param("concepto") String concepto);
	
}
