package com.altima.springboot.app.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.altima.springboot.app.models.entity.DisenioFamiliaComposicionForro;
import com.altima.springboot.app.models.entity.DisenioFamiliaComposicionTela;
import com.altima.springboot.app.models.entity.DisenioForro;
import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioMaterial;
//import com.altima.springboot.app.models.entity.DisenioProceso;
import com.altima.springboot.app.models.entity.DisenioTela;
import com.altima.springboot.app.models.service.IDisenioFamiliaComposicionForroService;
import com.altima.springboot.app.models.service.IDisenioFamiliaComposicionTelaService;
import com.altima.springboot.app.models.service.IDisenioForroService;
import com.altima.springboot.app.models.service.IDisenioMaterialService;
//import com.altima.springboot.app.models.service.IDisenioProcesoService;
import com.altima.springboot.app.models.service.IDisenioTelaService;
import com.altima.springboot.app.models.service.IUploadService;



@Controller

public class MaterialesController {
	
	
	@Autowired
	private IDisenioMaterialService disenioMaterialService;
	
	@Autowired
	private IDisenioForroService forroService;
	@Autowired
	private IDisenioTelaService disenioTelaService;
	@Autowired
	private IDisenioFamiliaComposicionTelaService ComposicionTelaService;
	@Autowired
	private IUploadService UploadService;
	@Autowired
	private IDisenioFamiliaComposicionForroService ComposicionForroService;
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
	
	
	
	
	
	@GetMapping("/agregar-material") 
	public String agregarMaterial(Model model) {
		DisenioMaterial material = new DisenioMaterial();
		List<DisenioLookup> listLookupsMed = disenioMaterialService.findListaLookupMed();
		List<DisenioLookup> listLookupsMar = disenioMaterialService.findListaMarcas();
		List<DisenioLookup> listLookupsClasificacion = disenioMaterialService.findListaClasificacion();	
		List<DisenioLookup> listClaveProceso = disenioMaterialService.findListaLookupPro();
		List<DisenioLookup> listLookupsMat = disenioMaterialService.findListaLookupMat();
		List<DisenioLookup> listLookupsCol = disenioMaterialService.findListaColor();
		model.addAttribute("material", material);
		model.addAttribute("listLookupsMed", listLookupsMed);
		model.addAttribute("listLookupsMar", listLookupsMar);
		model.addAttribute("listLookupsClasificacion", listLookupsClasificacion);
		model.addAttribute("listClaveProceso", listClaveProceso);
		model.addAttribute("listLookupsMat", listLookupsMat);
		model.addAttribute("listLookupsCol", listLookupsCol);
		System.out.println("epale eaple si entro al method get");
		
		// Comienza erik
		DisenioForro forro = new DisenioForro();
		model.addAttribute("forro", forro);
		model.addAttribute("lisFam",disenioTelaService.findAllFamilaComposicion());
		
		//agregar tela
		DisenioTela tela = new DisenioTela(); 
		model.addAttribute("listForro",forroService.findAll()); 
		model.addAttribute("listBoton", disenioTelaService.findAllBotones(tela.getIdTela()));
		model.addAttribute("listColor", disenioTelaService.findAllColores());
		model.addAttribute("listPrendas", disenioTelaService.findAllPrenda());
		model.addAttribute("tela", tela);
		return "agregar-material";
		
		
	}
	
	
	
	@PostMapping("guardar")
	public String guardarMaterial(@ModelAttribute DisenioMaterial material,  RedirectAttributes redirectAttrs) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (material.getIdMaterial() ==null || material.getIdMaterial() <=0) {
			System.out.println(auth.getName() + "aqui esta el mero mero");
			material.setCreadoPor(auth.getName());
			disenioMaterialService.save(material);
			material.setIdText("MAE" + (material.getIdMaterial() + 1000));
			material.setEstatus("1");
			disenioMaterialService.save(material);
			System.out.println("epale eaple si entro al method posts");
		     redirectAttrs.addFlashAttribute("title", "Material Insertado Correctamente").addFlashAttribute("icon", "success");
		} else {
			System.out.println(auth.getName() + "aqui esta el mero mero");
			material.setCreadoPor(material.getCreadoPor());
			material.setIdText("MAE" + (material.getIdMaterial() + 1000));
			material.setEstatus("1");
			
			material.setActualizadoPor(auth.getName());
			disenioMaterialService.save(material);
			  redirectAttrs.addFlashAttribute("title", "Material Actualizado Correctamente").addFlashAttribute("icon", "success");
			System.out.println("epale eaple si entro al method posts de editar");
			
			

		}
        return "redirect:materiales";
	}
	
	
	
	
	@GetMapping("editar-material{id}") 
	public String editarMaterial( @PathVariable("id") Long idMaterial, Model model) {
		
		DisenioMaterial material = disenioMaterialService.findOne(idMaterial);
	
		List<DisenioLookup> listLookupsMed = disenioMaterialService.findListaLookupMed();
		List<DisenioLookup> listLookupsMar = disenioMaterialService.findListaMarcas();
		List<DisenioLookup> listLookupsClasificacion = disenioMaterialService.findListaClasificacion();	
		List<DisenioLookup> listClaveProceso = disenioMaterialService.findListaLookupPro();
		List<DisenioLookup> listLookupsMat = disenioMaterialService.findListaLookupMat();
		List<DisenioLookup> listLookupsCol = disenioMaterialService.findListaColor();
		
		model.addAttribute("material", material);

		model.addAttribute("listLookupsMed", listLookupsMed);
		model.addAttribute("listLookupsMar", listLookupsMar);
		model.addAttribute("listLookupsClasificacion", listLookupsClasificacion);
		model.addAttribute("listClaveProceso", listClaveProceso);
		model.addAttribute("listLookupsMat", listLookupsMat);
		model.addAttribute("listLookupsCol", listLookupsCol);
		
		System.out.println("epale eaple si entro al method get2");
		//vuelvo incluir esto porque esnecesario para renderizar la vista
		// Comienza erik
				DisenioForro forro = new DisenioForro();
				model.addAttribute("forro", forro);
				model.addAttribute("lisFam",disenioTelaService.findAllFamilaComposicion());
				
				//agregar tela
				DisenioTela tela = new DisenioTela(); 
				model.addAttribute("listForro",forroService.findAll()); 
				model.addAttribute("listBoton", disenioTelaService.findAllBotones(tela.getIdTela()));
				model.addAttribute("listColor", disenioTelaService.findAllColores());
				model.addAttribute("listPrendas", disenioTelaService.findAllPrenda());
				model.addAttribute("tela", tela);
				return "agregar-material";
			
	}
	
	
	@GetMapping("delete-material{id}") 
	public String deleteMaterial(@PathVariable("id") Long idMaterial) {
		
		DisenioMaterial material = disenioMaterialService.findOne(idMaterial);
		material.setEstatus("0");
		disenioMaterialService.save(material);
		  
		  return "redirect:materiales";
	}
	
	
	
	
}

