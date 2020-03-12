package com.altima.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrendasController {
	
	@GetMapping("prendas") 
	public String listClothes() {
		return "prendas";
	}
	
	@GetMapping("detalle-prenda") 
	public String infoClothes() {
		return "detalle-prenda";
	}
	

}
