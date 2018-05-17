package com.ejemplo.spring.data.jdbc.persistence;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.spring.data.jdbc.entities.Factura;

public interface FacturaDao extends PagingAndSortingRepository<Factura, Long>{

	@Transactional(propagation=Propagation.REQUIRED)
	@Query("SELECT * FROM FACTURA WHERE concepto = :concepto")
	List<Factura> findByConcepto(@Param("concepto") String concepto);
	
	@Modifying
	@Query("INSERT INTO FACTURA (id,concepto) VALUES (:id, :concepto)")
	boolean insert(@Param("id") Long id, @Param("concepto") String concepto);
	
}
