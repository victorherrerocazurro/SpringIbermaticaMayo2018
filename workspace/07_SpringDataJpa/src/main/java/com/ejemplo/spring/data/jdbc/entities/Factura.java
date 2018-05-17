package com.ejemplo.spring.data.jdbc.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Factura {

	@Id
	private long id;//PK
	private String concepto;
	
	public Factura(long id, String concepto) {
		super();
		this.id = id;
		this.concepto = concepto;
	}
	public Factura() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	@Override
	public String toString() {
		return "Factura [id=" + id + ", concepto=" + concepto + "]";
	}
}
