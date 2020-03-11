package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
	
	@GetMapping("/clientes") 
	public String listClients() {
		return "clientes";
	}

	@GetMapping("/agregar-cliente") 
	public String addClients() {
		return "agregar-cliente";
	}

}
