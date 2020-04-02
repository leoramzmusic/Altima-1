package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MuestrarioController {
	@GetMapping("/inventario")
	public String Inventario() {
		return "inventario";
	}

	@GetMapping("/agregar-inventario")
	public String agregarInventario() {
		return "agregar-inventario";
	}
	
	@GetMapping("/catalogos-muestrario")
	public String listCatalogo() {
		return "catalogos-muestrario";
	}
}
