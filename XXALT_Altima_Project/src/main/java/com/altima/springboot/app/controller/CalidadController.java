package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalidadController {

	@GetMapping("calidad") 
	public String listCalidad() {
		return "calidad";
	}
	
	@GetMapping("calidad-nueva-prueba") 
	public String addCalidad() {
		return "calidad-nueva-prueba";
	}
	
	@GetMapping("detalle-calidad") 
	public String infoCalidad() {
		return "detalle-calidad";
	}
}
