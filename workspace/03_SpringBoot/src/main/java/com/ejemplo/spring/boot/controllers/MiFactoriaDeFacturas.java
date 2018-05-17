package com.ejemplo.spring.boot.controllers;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.boot.dto.Factura;

@Component
public class MiFactoriaDeFacturas implements FactoryBean<Factura>{

	@Override
	public Factura getObject() throws Exception {
		return new Factura(12, "Desde Factoria");
	}

	@Override
	public Class<?> getObjectType() {
		return Factura.class;
	}

}
