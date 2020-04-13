package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovimientosController {

	@GetMapping("/movimientos") 
	public String listExits() {
		return "movimientos";
	}
	
	@GetMapping("/historico-de-muestras") 
	public String listHistorial() {
		return "historico-de-muestras";
	}
}
