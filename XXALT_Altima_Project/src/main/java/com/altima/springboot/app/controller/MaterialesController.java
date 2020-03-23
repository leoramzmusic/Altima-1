package com.altima.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.models.entity.DisenioProceso;
import com.altima.springboot.app.models.service.IDisenioMaterialService;
import com.altima.springboot.app.models.service.IDisenioProcesoService;


@Controller
public class MaterialesController {
	
	
	@Autowired
	private IDisenioMaterialService disenioMaterialService;
	
	
	@Autowired
	private IDisenioProcesoService disenioProcesoService;
	
	
	
	@GetMapping("materiales") 
	public String listMateriales(Model model) {
		
		List<Object []> disenioMaterial = disenioMaterialService.disenioMaterial();
		
		model.addAttribute("listarMateriales", disenioMaterial);
		
		
		
		
		return "materiales";
	}
	
	@GetMapping("detalle-material") 
	public String infoMaterials() {
		return "detalle-material";
	}
	
	
	
	
	
	@GetMapping("agregar-material") 
	public String agregarMaterial(Model model) {
		
		DisenioMaterial material = new DisenioMaterial();
		List<DisenioLookup> listLookupsMat = disenioMaterialService.findListaLookupMat();	
		List<DisenioLookup> listLookupsMed = disenioMaterialService.findListaLookupMed();
		List<DisenioLookup> listLookupsMar = disenioMaterialService.findListaMarcas();
		List<DisenioLookup> listLookupsClasificacion = disenioMaterialService.findListaClasificacion();	
		List<DisenioProceso> listClaveProceso = disenioProcesoService.findListClaveProceso();
		
		model.addAttribute("material", material);
		model.addAttribute("listLookupsMat", listLookupsMat);
		model.addAttribute("listLookupsMed", listLookupsMed);
		model.addAttribute("listLookupsMar", listLookupsMar);
		model.addAttribute("listLookupsClasificacion", listLookupsClasificacion);
		model.addAttribute("listClaveProceso", listClaveProceso);
		
		System.out.println("epale eaple si entro al method get");
		
		return "agregar-material";
		
		
	}
	
	
	
	@PostMapping("guardar")
	public String guardarMaterial(@ModelAttribute DisenioMaterial material) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println(auth.getName() + "aqui esta el mero mero");
		disenioMaterialService.save(material);
		
		material.setIdText("MAE" + (material.getIdMaterial() + 1000));
		
		disenioMaterialService.save(material);
		
			
		
		System.out.println("epale eaple si entro al method posts");

		   return "agregar-material";
	}
	
	
	


}

