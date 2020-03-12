package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaterialesController {
	
	@GetMapping("materiales") 
	public String listMaterials() {
		return "materiales";
	}
	
	@GetMapping("detalle-material") 
	public String infoMaterials() {
		return "detalle-material";
	}

}
