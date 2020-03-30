package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpedienteController {
	
	@GetMapping("/expediente") 
	public String expediente() {
		return "expediente";
	}
	
	@GetMapping("/agregar-expediente") 
	public String agregarExpediente() {
		return "agregar-expediente";
	}
	
	@GetMapping("/agregar-expediente-empleados") 
	public String agregarEmpleadosExpediente() {
		return "agregar-expediente-empleados";
	}
	
	@GetMapping("/detalle-expediente") 
	public String detalleExpediente() {
		return "detalle-expediente";
	}
	
}
