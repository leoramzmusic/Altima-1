package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgenteVentaController {
	
	@GetMapping("/seguimientos") 
	public String listSeguimientos() {
		return "seguimientos";
	}
	
	@GetMapping("/carga-de-pedidos") 
	public String listPedidos() {
		return "carga-de-pedidos";
	}

}
