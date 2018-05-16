package com.ejemplo.spring.boot.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

//Bean de Controlador
@Controller
@RequestMapping("/holamundo")
public class HolaMundoController {

	//1-MVC
	
	//Metodos de Accion
	@GetMapping
	//Retornar la clave e una vista
	public String saludar(Map<String, Object> model){
		return null;
	}
	
	//Metodos de Accion
	@GetMapping("/buenosdias")
	//Retornamos el objeto View
	public View buenosdias(Model model){
		return null;
	}
	
	//Metodos de Accion
	@GetMapping("/buenasnoches")
	public ModelAndView buenasnoches(){
		return null;
	}
}
