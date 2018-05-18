package com.ejemplo.spring;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class Configuracion {

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}
	
	@Bean
	public ServicioFecha servicioFecha(){
		return new ServicioFecha();
	}

}
