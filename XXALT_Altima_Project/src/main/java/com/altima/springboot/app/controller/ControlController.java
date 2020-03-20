package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControlController {
	@GetMapping("/control-de-produccion") 
	public String listControlProduccion() {
		return "control-de-produccion";
	}

}
