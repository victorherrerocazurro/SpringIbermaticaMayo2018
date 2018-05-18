package com.ejemplo.spring;

import java.util.Date;
import java.util.logging.Logger;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public class ServicioFecha {
	
	private static Logger _log = Logger.getLogger(ServicioFecha.class.getName());
	
	@Cacheable("fecha")
	public Date getFecha() {
		return new Date();
	}

	@CacheEvict(value = "fecha", allEntries = true)
	public void resetear() {
		_log.info("Resetando la cache");
	}

	@CachePut(value = "fecha")
	public Date actualizar() {
		_log.info("Actualziar la cache");
		return new Date();
	}
}
