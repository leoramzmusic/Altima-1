package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduccionController {

	@GetMapping("/produccion-fechas-pedido") 
	public String produccionFechas() {
		return "produccion-fechas-pedido";
	}
	
	@GetMapping("/prendas-faltantes")
	public String pedidosFaltantes() {
		return "prendas-faltantes";
	}
	
	@GetMapping("/pedidos-entregados")
	public String pedidosEntregados() {
		return "pedidos-entregados";
	}
	
	@GetMapping("/impresion-etiquetas")
	public String impresionEtiquetas() {
		return "impresion-etiquetas";
	}
	
	@GetMapping("/hojas-tonos")
	public String hojasTonos() {
		return "hojas-tonos";
	}
}
