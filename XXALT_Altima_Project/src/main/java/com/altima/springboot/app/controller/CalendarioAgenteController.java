package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarioAgenteController {
	@GetMapping("agenda-agente")
	public String calendarAgente() {
		
		return "agenda-agente";
	}
}
