package com.altima.springboot.app.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.altima.springboot.app.models.entity.DisenioForro;
import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioMaterial;
//import com.altima.springboot.app.models.entity.DisenioProceso;
import com.altima.springboot.app.models.entity.DisenioTela;

import com.altima.springboot.app.models.service.IDisenioForroService;
import com.altima.springboot.app.models.service.IDisenioMaterialService;
//import com.altima.springboot.app.models.service.IDisenioProcesoService;
import com.altima.springboot.app.models.service.IDisenioTelaService;
import com.altima.springboot.app.models.service.IUploadService;

@CrossOrigin(origins = { "*" })
@Controller
public class MaterialesController {

	@Autowired
	private IDisenioMaterialService disenioMaterialService;

	@Autowired
	private IDisenioForroService forroService;
	@Autowired
	private IDisenioTelaService disenioTelaService;
	
	@Autowired
	private IUploadService UploadService;

	@GetMapping("/materiales")
	public String listMateriales(Model model) {

		List<Object[]> disenioMaterial = disenioMaterialService.disenioMaterial();

		model.addAttribute("listarMateriales", disenioMaterial);

		return "materiales";
	}

	@GetMapping("detalle-material/{tipo}/{id}")
	public String infoMaterials(@PathVariable("id") Long id, @PathVariable("tipo") String tipo, Model model) {
		if (tipo.equals("material")) {
			model.addAttribute("tipo", "material");
			model.addAttribute("h3", "Consulta de Material");
			DisenioMaterial dm;
			dm = disenioMaterialService.findOne(id);
			model.addAttribute("h2", dm.getNombreMaterial());
			model.addAttribute("material", disenioMaterialService.findByIdMaterial(id));

		} else if (tipo.equals("tela")) {
			model.addAttribute("listVistaTelaPrenda", disenioTelaService.VistaTelaPrenda(id));
			model.addAttribute("h3", "Consulta de Tela");
			model.addAttribute("tela", disenioTelaService.findPrendaById(id));
			model.addAttribute("listTelaComposicon", disenioTelaService.ComposicionTelaMN(id));
			model.addAttribute("tipo", "tela");
		} else if (tipo.equals("forro")) {
			model.addAttribute("h3", "Consulta de Forro");
			DisenioForro forro;
			forro = forroService.findOne(id);
			model.addAttribute("forro", forro);
			model.addAttribute("listForroComposicon", disenioTelaService.ComposicionForroMN(id));
			model.addAttribute("h2", forro.getNombreForro());
			model.addAttribute("tipo", "forro");
		} else {
			return "redirect:/materiales";
		}
		return "detalle-material";
	}

	@GetMapping("/agregar-material")
	public String agregarMaterial(Model model) {
		model.addAttribute("form", "default");
		// DisenioMaterial material = new DisenioMaterial();
		// List<DisenioLookup> listLookupsMed = disenioMaterialService.findListaLookupMed();
		// List<DisenioLookup> listLookupsMar = disenioMaterialService.findListaMarcas();
		// List<DisenioLookup> listLookupsClasificacion = disenioMaterialService.findListaClasificacion();
		// List<DisenioLookup> listClaveProceso = disenioMaterialService.findListaLookupPro();
		// List<DisenioLookup> listLookupsMat = disenioMaterialService.findListaLookupMat();
		// List<DisenioLookup> listLookupsCol = disenioMaterialService.findListaColor();
		// model.addAttribute("material", material);
		// model.addAttribute("listLookupsMed", listLookupsMed);
		// model.addAttribute("listLookupsMar", listLookupsMar);
		// model.addAttribute("listLookupsClasificacion", listLookupsClasificacion);
		// model.addAttribute("listClaveProceso", listClaveProceso);
		// model.addAttribute("listLookupsMat", listLookupsMat);
		// model.addAttribute("listLookupsCol", listLookupsCol);

		// // Comienza erik
		// DisenioForro forro = new DisenioForro();
		// model.addAttribute("forro", forro);
		// model.addAttribute("lisFam", disenioTelaService.findAllFamilaComposicion());

		// model.addAttribute("lisCom", disenioTelaService.findAllComposicion());

		// // agregar tela
		// DisenioTela tela = new DisenioTela();
		// model.addAttribute("listForro", forroService.findAll());
		// model.addAttribute("listBoton", disenioTelaService.findAllBotones(tela.getIdTela()));
		// model.addAttribute("listColor", disenioTelaService.findAllColores());
		// model.addAttribute("listPrendas", disenioTelaService.findAllPrenda());
		// model.addAttribute("tela", tela);
		return "agregar-material";

	}

	@GetMapping("/agregar-material/{tipo}")
	public String agregarMaterial(Model model,@PathVariable(name="tipo")String tipo) {
		
		if(tipo.equals("material")){
			
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
			model.addAttribute("form", "material");
		}
		else if(tipo.equals("forro")){
			
			DisenioForro forro = new DisenioForro();
			model.addAttribute("forro", forro);
			model.addAttribute("lisFam", disenioTelaService.findAllFamilaComposicion());
			model.addAttribute("lisCom", disenioTelaService.findAllComposicion());
			model.addAttribute("form", "forro");
		}
		else if(tipo.equals("tela")){
			
			DisenioTela tela = new DisenioTela();
			model.addAttribute("listForro", forroService.findAll());
			model.addAttribute("listBoton", disenioTelaService.findAllBotones(tela.getIdTela()));
			model.addAttribute("listColor", disenioTelaService.findAllColores());
			model.addAttribute("listPrendas", disenioTelaService.findAllPrenda());
			model.addAttribute("tela", tela);
			model.addAttribute("form", "tela");
		}
		else{
			return("redirect:materiales");
		}


		return "agregar-material";

	}

	@PostMapping("/guardar")
	public String guardarMaterial(@ModelAttribute DisenioMaterial material, RedirectAttributes redirectAttrs,
			@RequestParam(value="imagenMaterial", required=false) MultipartFile imagenMaterial) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	
		
		 System.out.println("la calidad guardar1" + material.getCalidad());
			if (material.getCalidad()==null) {
				material.setCalidad("0");
				
				
			}
			
		
			
		
		
		if (material.getIdMaterial() == null || material.getIdMaterial() <= 0) {
			material.setCreadoPor(auth.getName());
			material.setEstatusMaterial("0");
			
			if (!imagenMaterial.isEmpty()){
				if ( material.getImagen() != null && material.getImagen().length() > 0) {
					UploadService.deleteMaterial(material.getImagen());
				}
				String uniqueFilename = null;
				try {
					uniqueFilename = UploadService.copyMaterial(imagenMaterial);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				material.setImagen(uniqueFilename);
			}
			
			//aqui acaba lo de la imagen
			
			disenioMaterialService.save(material);
			if (disenioMaterialService.findLastMaterial(material.getIdTipoMaterial()).size() > 1) {
				Object[] vat = disenioMaterialService.findLastMaterial(material.getIdTipoMaterial()).get(1);
				String var = (String) vat[2];
				String var1 = (String) vat[5];
				String prefijo = var1.substring(0, 3);
				String[] part = var.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				material.setIdTextProspecto("PROSP" + prefijo.toUpperCase() + "00" + (cont + 1));
			} else {
				Object[] vat = disenioMaterialService.findLastMaterial(material.getIdTipoMaterial()).get(0);
				String var = (String) vat[5];
				String prefijo = var.substring(0, 3);
				material.setIdTextProspecto("PROSP" + prefijo.toUpperCase() + "0010");
			}
			material.setEstatusMaterial("0");
			if (disenioMaterialService.findLastMaterial(material.getIdTipoMaterial()).size() > 1) {
				Object[] vat = disenioMaterialService.findLastMaterial(material.getIdTipoMaterial()).get(1);
				String var = (String) vat[2];
				String var1 = (String) vat[5];
				String prefijo = var1.substring(0, 3);
				String[] part = var.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				material.setIdText( prefijo.toUpperCase() + "00" + (cont + 1));
			} else {
				Object[] vat = disenioMaterialService.findLastMaterial(material.getIdTipoMaterial()).get(0);
				String var = (String) vat[5];
				String prefijo = var.substring(0, 3);
				material.setIdText( prefijo.toUpperCase() + "0010");
			}
		
			material.setEstatus("1");
			
			if (!imagenMaterial.isEmpty()){
				if ( material.getImagen() != null && material.getImagen().length() > 0) {
					UploadService.deleteMaterial(material.getImagen());
				}
				String uniqueFilename = null;
				try {
					uniqueFilename = UploadService.copyMaterial(imagenMaterial);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				material.setImagen(uniqueFilename);
			}
			//aqui acaba lo de la imagen
		
			disenioMaterialService.save(material);
			redirectAttrs.addFlashAttribute("title", "Material Insertado Correctamente").addFlashAttribute("icon",
					"success");
		} else {
			
			
			//System.out.println("aqui esta el id"+ material.getIdMaterial());
			//material= disenioMaterialService.findOne(material.getIdMaterial());
		
			material.setCreadoPor(material.getCreadoPor());

			material.setEstatus("1");
			
			
			if (disenioMaterialService.findLastMaterial(material.getIdTipoMaterial()).size() > 1) {
				Object[] vat = disenioMaterialService.findLastMaterial(material.getIdTipoMaterial()).get(1);
				String var = (String) vat[2];
				String var1 = (String) vat[5];
				String prefijo = var1.substring(0, 3);
				String[] part = var.split("(?<=\\D)(?=\\d)");
				Integer cont = Integer.parseInt(part[1]);
				material.setIdText( prefijo.toUpperCase() + "00" + (cont + 1));
			} else {
				Object[] vat = disenioMaterialService.findLastMaterial(material.getIdTipoMaterial()).get(0);
				String var = (String) vat[5];
				String prefijo = var.substring(0, 3);
				material.setIdText( prefijo.toUpperCase() + "0010");
			}

			material.setActualizadoPor(auth.getName());
			
			if (!imagenMaterial.isEmpty()){
				if ( material.getImagen() != null && material.getImagen().length() > 0) {
					UploadService.deleteMaterial(material.getImagen());
				}
				String uniqueFilename = null;
				try {
					uniqueFilename = UploadService.copyMaterial(imagenMaterial);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				material.setImagen(uniqueFilename);
			}
			disenioMaterialService.save(material);
			redirectAttrs.addFlashAttribute("title", "Material Actualizado Correctamente").addFlashAttribute("icon",
					"success");

		}
		return "redirect:materiales";
	}

	@GetMapping("/editar-material/{id}")
	public String editarMaterial(@PathVariable("id") Long idMaterial, Model model) {
		model.addAttribute("form", "material");
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
		return "agregar-material";

	}

	@GetMapping("/delete-material/{id}")
	public String deleteMaterial(@PathVariable("id") Long idMaterial) {

		DisenioMaterial material = disenioMaterialService.findOne(idMaterial);
		material.setEstatus("0");
		disenioMaterialService.save(material);

		return "redirect:/materiales";
	}
	
	
	@GetMapping(value = "/uploads/material/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;
		try {
			recurso = UploadService.loadMaterial(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}

}
