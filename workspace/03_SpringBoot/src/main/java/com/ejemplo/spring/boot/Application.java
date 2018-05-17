package com.ejemplo.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ejemplo.spring.boot.dto.Factura;

@SpringBootApplication
@EnableWebMvc
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		Factura factura = context.getBean(Factura.class);
		
		System.out.println(factura.getConcepto());
	}
}
