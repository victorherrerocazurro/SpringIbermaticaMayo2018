package com.ejemplo.spring.jdbc.entities;

public class Factura {

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
	
	public long getId() {
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
