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

import com.altima.springboot.app.models.entity.DisenioFamiliaComposicionForro;
import com.altima.springboot.app.models.entity.DisenioFamiliaComposicionTela;
import com.altima.springboot.app.models.entity.DisenioForro;
import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.models.entity.DisenioProceso;
import com.altima.springboot.app.models.entity.DisenioTela;
import com.altima.springboot.app.models.service.IDisenioFamiliaComposicionForroService;
import com.altima.springboot.app.models.service.IDisenioFamiliaComposicionTelaService;
import com.altima.springboot.app.models.service.IDisenioForroService;
import com.altima.springboot.app.models.service.IDisenioMaterialService;
import com.altima.springboot.app.models.service.IDisenioProcesoService;
import com.altima.springboot.app.models.service.IDisenioTelaService;
import com.altima.springboot.app.models.service.IUploadService;



@Controller

public class MaterialesController {
	
	
	@Autowired
	private IDisenioMaterialService disenioMaterialService;
	@Autowired
	private IDisenioProcesoService disenioProcesoService;
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
	
	
	
	
	
	@GetMapping("agregar-material") 
	public String agregarMaterial(Model model) {
		DisenioMaterial material = new DisenioMaterial();
		List<DisenioLookup> listLookupsMed = disenioMaterialService.findListaLookupMed();
		List<DisenioLookup> listLookupsMar = disenioMaterialService.findListaMarcas();
		List<DisenioLookup> listLookupsClasificacion = disenioMaterialService.findListaClasificacion();	
		List<DisenioProceso> listClaveProceso = disenioProcesoService.findListClaveProceso();
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
		model.addAttribute("listBoton", disenioTelaService.findAllBotones());
		model.addAttribute("listColor", disenioTelaService.findAllColores());
		model.addAttribute("listPrendas", disenioTelaService.findAllPrenda());
		model.addAttribute("tela", tela);
		return "agregar-material";
		
		
	}
	
	
	
	@PostMapping("guardar")
	public String guardarMaterial(@ModelAttribute DisenioMaterial material) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (material.getIdMaterial() ==null || material.getIdMaterial() <=0) {
			System.out.println(auth.getName() + "aqui esta el mero mero");
			material.setCreadoPor(auth.getName());
			disenioMaterialService.save(material);
			material.setIdText("MAE" + (material.getIdMaterial() + 1000));
			material.setEstatus("1");
			disenioMaterialService.save(material);
			System.out.println("epale eaple si entro al method posts");
		} else {
			System.out.println(auth.getName() + "aqui esta el mero mero");
			material.setCreadoPor(material.getCreadoPor());
			material.setIdText("MAE" + (material.getIdMaterial() + 1000));
			material.setEstatus("1");
			
			material.setActualizadoPor(auth.getName());
			disenioMaterialService.save(material);
	
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
		List<DisenioProceso> listClaveProceso = disenioProcesoService.findListClaveProceso();
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
				model.addAttribute("listBoton", disenioTelaService.findAllBotones());
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
	
	
	
	/*
	@PostMapping("guardar-forro")
	public String guardar_forro(
			DisenioForro forro,
			@RequestParam("txtTablaf") String composicion,
			@RequestParam("txtTabla2f") String idComposicion) {
		Date date = new Date();
		
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
			forro.setIdText("FORRO");
			forro.setCreadoPor(auth.getName());
			
			forro.setIdUnidadMedida(Long.valueOf(1));
			forro.setConsumoPromedioForro("null");
			forro.setExistenciaForro("36");
		
			forro.setFechaCreacion(hourdateFormat.format(date));
			forro.setUltimaFechaModificacion(hourdateFormat.format(date));
			forroService.save(forro);
			
			
			forroService.save(forro);
			
			String [] vect = composicion.split(",");
			String [] vect2 = idComposicion.split(",");
			for(int i= 0 ; i<vect.length -1;i++) {
				DisenioFamiliaComposicionForro ff = new DisenioFamiliaComposicionForro();
				ff.setIdFamiliaComposicion(Long.valueOf(vect2[i]));
				ff.setIdForro(forro.getIdForro());
				ff.setCreadoPor(auth.getName());
				ff.setActualizadoPor("null");
				ff.setFechaCreacion(hourdateFormat.format(date));
				ff.setUltimaFechaModificacion(hourdateFormat.format(date));
				ff.setComposicion(vect[i]);
				ComposicionForroService.save(ff);
			}
			
		return "redirect:materiales";
	}
	
	
	
	
	
	
	
	
	@PostMapping("guardar-tela")
	public String guardar_tela( DisenioTela tela,
			@RequestParam("txtTabla") String composicion,
			@RequestParam("txtTabla2") String idComposicion
			) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Date date = new Date();
		tela.setIdFamiliaComposicion(Long.valueOf(1));
		tela.setIdCalidad(Long.valueOf(1));
		tela.setIdText("Prospecto");
		tela.setCreadoPor(auth.getName());
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		tela.setFechaCreacion(hourdateFormat.format(date));
		tela.setUltimaFechaModificacion(hourdateFormat.format(date));
	
		tela.setDescripcionTela("Prospecto");
		tela.setLineaTela("1");
		tela.setIdUnidadMedida("1");
		tela.setConsumoPromedio("1");
		tela.setExistencia("1");
		tela.setTipo("Prospecto");
		tela.setEstatus(0);  
		tela.setConsumo("1");
		tela.setIdFamiliaComposicion(Long.valueOf(1));
		tela.setFoto("aprueba");
		disenioTelaService.save(tela);
		
		String [] vect = composicion.split(",");
		String [] vect2 = idComposicion.split(",");
		for(int i= 0 ; i<vect.length -1;i++) {
			DisenioFamiliaComposicionTela fc = new DisenioFamiliaComposicionTela();
			
		
			fc.setIdFamiliaComposicion(Long.valueOf(vect2[i]));
			fc.setIdTela(tela.getIdTela());
		
			fc.setCreadoPor(auth.getName());
			fc.setActualizadoPor("null");
			fc.setFechaCreacion(hourdateFormat.format(date));
			fc.setUltimaFechaModificacion(hourdateFormat.format(date));;
			fc.setComposicion(vect[i]);
			ComposicionTelaService.save(fc);
		}
		return "redirect:materiales";
	}*/
}

