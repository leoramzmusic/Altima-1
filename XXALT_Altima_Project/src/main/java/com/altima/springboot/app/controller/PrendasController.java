package com.altima.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.models.entity.DisenioPrenda;
import com.altima.springboot.app.models.entity.DisenioRuta;
import com.altima.springboot.app.models.service.IDisenioFamiliaPrendaService;
import com.altima.springboot.app.models.service.IDisenioMaterialService;
import com.altima.springboot.app.models.service.IDisenioPrendaService;
import com.altima.springboot.app.models.service.IDisenioRutaService;

@Controller
public class PrendasController {
	@Autowired
	IDisenioPrendaService disenioPrendaService;
	@Autowired
	IDisenioFamiliaPrendaService disenioFamiliaPrendaService;
	@Autowired
	IDisenioMaterialService disenioMaterialService;
	@Autowired
	IDisenioRutaService disenioRutaService;
	
	@GetMapping("prendas") 
	public String listClothes(Model model, Map<String, Object> m) 
	{
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
		model.addAttribute("materiales", disenioMaterialService.findAllForCreate());
		model.addAttribute("patronajes", disenioMaterialService.findLookUps());
		model.addAttribute("rutas", disenioRutaService.findAll());
		m.put("disenio", disenio);
		return "agregar-prenda";
	}
	
	@RequestMapping(value= "/editar-prenda/{id}")
	public String editar(@PathVariable (value="id") Long id, Map<String, Object> m, Model model ) 
	{
		System.out.println("entre al editar jsjs");
		DisenioPrenda disenio = new DisenioPrenda();
		model.addAttribute("familias", disenioFamiliaPrendaService.findAll());
		model.addAttribute("materiales", disenioMaterialService.findAllForCreate());
		model.addAttribute("patronajes", disenioMaterialService.findLookUps());
		model.addAttribute("rutas", disenioRutaService.findAll());
		m.put("disenio", disenio);
		return "editar-prenda";
	}

}
