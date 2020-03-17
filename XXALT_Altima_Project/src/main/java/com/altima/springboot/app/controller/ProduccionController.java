package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduccionController {

	@GetMapping("/produccion-fechas-pedido") 
	public String produccionFechas() {
		return "produccion-fechas-pedido";
	}
}
