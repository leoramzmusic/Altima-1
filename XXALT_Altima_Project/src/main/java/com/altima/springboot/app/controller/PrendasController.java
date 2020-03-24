package com.altima.springboot.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.models.entity.DisenioPrenda;
import com.altima.springboot.app.models.service.IDisenioFamiliaPrendaService;
import com.altima.springboot.app.models.service.IDisenioMaterialService;
import com.altima.springboot.app.models.service.IDisenioPrendaService;

@Controller
public class PrendasController {
	@Autowired
	IDisenioPrendaService disenioPrendaService;
	@Autowired
	IDisenioFamiliaPrendaService disenioFamiliaPrendaService;
	@Autowired
	IDisenioMaterialService disenioMaterialService;
	
	@GetMapping("prendas") 
	public String listClothes(Model model, Map<String, Object> m) {
		model.addAttribute("prendas",disenioPrendaService.findAll());
		
		return "prendas";
	}
	
	@GetMapping("detalle-prenda") 
	public String infoClothes() {

		return "detalle-prenda";
	}
	
	@GetMapping("agregar-prenda") 
	public String addClothes(Model model, Map<String, Object> m) 
	{
		DisenioPrenda disenio = new DisenioPrenda();
		
		model.addAttribute("familias", disenioFamiliaPrendaService.findAll());
		model.addAttribute("materiales", disenioMaterialService.findAll());
		model.addAttribute("patronajes", disenioMaterialService.findLookUps());
		m.put("disenio", disenio);
		return "agregar-prenda";
	}
	

}
