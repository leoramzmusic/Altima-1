package com.altima.springboot.app.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.altima.springboot.app.models.entity.DisenioFamiliaComposicionForro;
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
public class ForroController {
	
	@Autowired
	private IDisenioMaterialService disenioMaterialService;
	@Autowired
	private IDisenioProcesoService disenioProcesoService;
	@Autowired
	private IDisenioForroService forroService;
	@Autowired
	private IDisenioTelaService disenioTelaService;
	@Autowired
	private IUploadService UploadService;
	@Autowired
	private IDisenioFamiliaComposicionForroService ComposicionForroService;
	

	@PostMapping("guardar-forro")
	public String guardar_forro(
			DisenioForro forro,
			@RequestParam("txtTablaf") String composicion,
			@RequestParam("txtTabla2f") String idComposicion,
			@RequestParam(value="imagenForro", required=false) MultipartFile imagenForro) {
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if ( forro.getIdForro() == null || forro.getEstatusForro().equals("0")){
			
			System.out.println("Entra if de id null y estatus forro 0 forro");
			forro.setIdText("FORRO");
			forro.setCreadoPor(auth.getName());
			
			forro.setIdUnidadMedida(Long.valueOf(1));
			forro.setConsumoPromedioForro("null");
			forro.setExistenciaForro("1");
		
			forro.setFechaCreacion(hourdateFormat.format(date));
			forro.setUltimaFechaModificacion(hourdateFormat.format(date));
			forro.setEstatus("1");
			forro.setEstatusForro("0");
			forro.setFoto("Sin imagen");
			forroService.save(forro);
			ComposicionForroService.deleteLista(forro.getIdForro());
			
			if ( composicion.length()>1) {
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
			}
		}
		else {
			if (!imagenForro.isEmpty()){
				if ( forro.getFoto() != null && forro.getFoto().length() > 0) {

					UploadService.deleteForro(forro.getFoto());
				}
				
				String uniqueFilename = null;
				try {
					uniqueFilename = UploadService.copyForro(imagenForro);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				forro.setFoto(uniqueFilename);
			}
			
			ComposicionForroService.deleteLista(forro.getIdForro());
			forro.setEstatus("1");
			forro.setFechaCreacion(hourdateFormat.format(date));
			forro.setUltimaFechaModificacion(hourdateFormat.format(date));
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
		}
			
			
		return "redirect:materiales";
	}
	
	
	@GetMapping("editar-forro/{id}")
	public String editar(@PathVariable(value="id") Long id , Model model) {
		DisenioTela tela = new DisenioTela() ;
		DisenioMaterial material = new DisenioMaterial();
		List<DisenioLookup> listLookupsMed = disenioMaterialService.findListaLookupMed();
		List<DisenioLookup> listLookupsMar = disenioMaterialService.findListaMarcas();
		List<DisenioLookup> listLookupsClasificacion = disenioMaterialService.findListaClasificacion();	
		List<DisenioProceso> listClaveProceso = disenioProcesoService.findListClaveProceso();
		List<DisenioLookup> listLookupsMat = disenioMaterialService.findListaLookupMat();
		List<DisenioLookup> listLookupsCol = disenioMaterialService.findListaColor();
		model.addAttribute("material", material);
		model.addAttribute("tela", tela);
		model.addAttribute("listLookupsMed", listLookupsMed);
		model.addAttribute("listLookupsMar", listLookupsMar);
		model.addAttribute("listLookupsClasificacion", listLookupsClasificacion);
		model.addAttribute("listClaveProceso", listClaveProceso);
		model.addAttribute("listLookupsMat", listLookupsMat);
		model.addAttribute("listLookupsCol", listLookupsCol);
		
		// Comienza erik
				
		model.addAttribute("lisFam",disenioTelaService.findAllFamilaComposicion());
		
		model.addAttribute("listForro",forroService.findAll()); 
		model.addAttribute("listBoton", disenioTelaService.findAllBotones(null));
		model.addAttribute("listColor", disenioTelaService.findAllColores());
		model.addAttribute("listPrendas", disenioTelaService.findAllPrenda());
				
				
		DisenioForro forro;
		forro=forroService.findOne(id);
		model.addAttribute("forro", forro);
		model.addAttribute("listForroComposicon", disenioTelaService.ComposicionForroMN(id));
		System.out.println("Entra a la consulta de forro composicion");
		
		
		
		return"agregar-material";   
	}
	
	@GetMapping(value = "/uploads/forros/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;
		try {
			recurso = UploadService.loadForro(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}
	

}
