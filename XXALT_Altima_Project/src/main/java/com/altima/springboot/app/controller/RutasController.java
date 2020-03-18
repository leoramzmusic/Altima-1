package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutasController {
	@GetMapping("/rutas") 
	public String listRutas() {
		return "rutas";
	}

}
