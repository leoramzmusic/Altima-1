package com.altima.springboot.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarioAgenteController {
	@GetMapping("agenda-agente")
	public String calendarAgente( HttpServletRequest request, Model model) {
		return "agenda-agente";
	}
}
