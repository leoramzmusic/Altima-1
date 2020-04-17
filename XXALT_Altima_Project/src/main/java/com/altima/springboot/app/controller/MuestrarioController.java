package com.altima.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.altima.springboot.app.models.entity.ProduccionDetallePedido;
import com.altima.springboot.app.models.service.IInventarioService;

@Controller
public class MuestrarioController {
	
	@Autowired
	private IInventarioService inventario;
	
	
	@GetMapping("/inventario")
	public String Inventario(Model model) {
		
		List<ProduccionDetallePedido> listInventario= inventario.listInventario();
		model.addAttribute("listInventario", listInventario);
		System.out.println("Si esta entrando al controller");	
		return "inventario";
	}
	
	@GetMapping("/catalogos-muestrario")
	public String listCatalogo() {
		return "catalogos-muestrario";
	}
}
