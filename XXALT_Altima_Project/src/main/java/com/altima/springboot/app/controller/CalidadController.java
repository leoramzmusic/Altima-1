package com.altima.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.altima.springboot.app.models.service.IDisenioCalidadService;


@Controller
public class CalidadController {
	
	@Autowired
	IDisenioCalidadService disenioCalidad;
	
	@GetMapping("calidad") 
	public String listCalidad(Model model) {
		disenioCalidad.findAll();
		model.addAttribute("calidadComponentes",disenioCalidad.findAll());
		
		return "calidad";
	}
	
	@GetMapping("calidad-nueva-prueba") 
	public String addCalidad() {
		return "calidad-nueva-prueba";
	}
	
	@GetMapping("detalle-calidad/id") 
	public String infoCalidad() {
		return "detalle-calidad";
	}
}
