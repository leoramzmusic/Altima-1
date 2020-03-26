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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.altima.springboot.app.models.entity.DisenioFamiliaComposicionTela;
import com.altima.springboot.app.models.entity.DisenioForro;
import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.models.entity.DisenioProceso;
import com.altima.springboot.app.models.entity.DisenioTela;
import com.altima.springboot.app.models.service.IDisenioFamiliaComposicionService;
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
	private IDisenioFamiliaComposicionService familaComposicion;
	
	@Autowired
	private IDisenioForroService forroService;
	
	@Autowired
	private IDisenioTelaService disenioTelaService;
	
	@Autowired
	private IDisenioFamiliaComposicionTelaService ComposicionTelaService;
	
	@Autowired
	private IUploadService UploadService;
	
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
		model.addAttribute("material", material);
		model.addAttribute("listLookupsMed", listLookupsMed);
		model.addAttribute("listLookupsMar", listLookupsMar);
		model.addAttribute("listLookupsClasificacion", listLookupsClasificacion);
		model.addAttribute("listClaveProceso", listClaveProceso);
		System.out.println("epale eaple si entro al method get");
		DisenioForro forro = new DisenioForro();
		model.addAttribute("forro", forro);
		model.addAttribute("lisFam",familaComposicion.findAll());
		
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
		
		System.out.println(auth.getName() + "aqui esta el mero mero");
		
		material.setCreadoPor(auth.getName());
		disenioMaterialService.save(material);
		
		material.setIdText("MAE" + (material.getIdMaterial() + 1000));
		
		disenioMaterialService.save(material);
		
			
		
		System.out.println("epale eaple si entro al method posts");

		   return "agregar-material";
	}
	
	
	@PostMapping("guardar-forro")
	public String guardar_forro( DisenioForro forro) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(forro.getIdForro()==null) {
			forro.setIdText("FORRO");
			forro.setCreadoPor(auth.getName());
			forro.setClaveForro("Forro");
			forro.setIdUnidadMedida(Long.valueOf(1));
			forro.setConsumoPromedioForro("null");
			forro.setExistenciaForro("36");
			forroService.save(forro);
			forro.setClaveForro("Forro"+forro.getIdForro());
			forroService.save(forro);
		}else {
			forro.setActualizadoPor(auth.getName());
			Date date = new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			forro.setUltimaFechaModificacion(hourdateFormat.format(date));}
		return "redirect:materiales";
	}
	
	
	@PostMapping("guardar-tela")
	public String guardar_tela( DisenioTela tela,
			@RequestParam("f1") Long f1,
			@RequestParam("f2") Long f2,
			@RequestParam("f3") Long f3,
			@RequestParam("b1") Long b1,
			@RequestParam("b2") Long b2,
			@RequestParam("b3") Long b3,
			@RequestParam("txtTabla") String composicion,
			@RequestParam("txtTabla2") String idComposicion,
			@RequestParam("imagenTela") MultipartFile imagenTela
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
		tela.setClaveTela("Prospecto");
		tela.setDescripcionTela("Prospecto");
		tela.setLineaTela("1");
		tela.setIdUnidadMedida("1");
		tela.setConsumoPromedio("1");
		tela.setExistencia("1");
		tela.setTipo("Prospecto");
		tela.setNombreTela("prospecto");
		tela.setEstatus(0);
		tela.setConsumo("1");
		String uniqueFilename = null;
		try {
			uniqueFilename = UploadService.copyTela(imagenTela);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tela.setFoto(uniqueFilename);
		disenioTelaService.save(tela);
		
		String [] vect = composicion.split(",");
		String [] vect2 = idComposicion.split(",");
		for(int i= 0 ; i<vect.length -1;i++) {
			DisenioFamiliaComposicionTela fc = new DisenioFamiliaComposicionTela();
			
			fc.setIdFamiliaComposicion(Long.valueOf(vect2[i]));
			fc.setIdTela(tela.getIdTela());
			fc.setEstatus(0);
			fc.setCreadoPor(auth.getName());
			fc.setActualizadoPor("null");
			fc.setFechaCreacion(hourdateFormat.format(date));
			fc.setUltimaFechaModificacion(hourdateFormat.format(date));;
			fc.setComposicion(vect[i]);
			ComposicionTelaService.save(fc);
		}
		return "redirect:materiales";
	}
	
	
	
}

