package com.altima.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.altima.springboot.app.models.service.IProduccionDetalleService;

@Controller
public class MuestrarioCatalogoController {
	
	@Autowired private IProduccionDetalleService pedidoDetalles;
	
	@GetMapping("/catalogos-muestrario")
	public String listCatalogo(Model model) {
		
		System.out.println(pedidoDetalles.muestrariosCatalogo());
		model.addAttribute("muestrario", pedidoDetalles.muestrariosCatalogo());
		
		return "catalogos-muestrario";
	}
}
