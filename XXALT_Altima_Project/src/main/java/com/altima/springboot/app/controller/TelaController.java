package com.altima.springboot.app.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.altima.springboot.app.models.entity.DisenioFamiliaComposicionTela;
import com.altima.springboot.app.models.entity.DisenioForro;
import com.altima.springboot.app.models.entity.DisenioLookup;
import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.models.entity.DisenioMaterialTela;
import com.altima.springboot.app.models.entity.DisenioProceso;
import com.altima.springboot.app.models.entity.DisenioTela;
import com.altima.springboot.app.models.entity.DisenioTelaForro;
import com.altima.springboot.app.models.entity.HrDireccion;
import com.altima.springboot.app.models.service.IDisenioFamiliaComposicionForroService;
import com.altima.springboot.app.models.service.IDisenioFamiliaComposicionTelaService;
import com.altima.springboot.app.models.service.IDisenioForroService;
import com.altima.springboot.app.models.service.IDisenioMaterialService;
import com.altima.springboot.app.models.service.IDisenioMaterialTelaService;
import com.altima.springboot.app.models.service.IDisenioProcesoService;
import com.altima.springboot.app.models.service.IDisenioTelaForroService;
import com.altima.springboot.app.models.service.IDisenioTelaService;
import com.altima.springboot.app.models.service.IUploadService;

@Controller
public class TelaController {
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
	
	@Autowired
	private IDisenioTelaForroService TelaForroService;
	
	@Autowired
	private IDisenioMaterialTelaService MaterialService;
	
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	/*
	@PostMapping("/guardar-tela")
	public String guardarCliente(DisenioTela tela ,
			DisenioTelaForro forro1,
			DisenioTelaForro forro2,
			DisenioTelaForro forro3,
			DisenioMaterialTela boton1,
			DisenioMaterialTela boton2,
			DisenioMaterialTela boton3,
			RedirectAttributes redirectAttrs) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if ( tela.getIdTela()== null){
			tela.setIdFamiliaComposicion(Long.valueOf(1));
			tela.setIdLookup(Long.valueOf(1));
			tela.setIdCalidad(Long.valueOf(1));
			tela.setIdText("Prospecto");
			tela.setCreadoPor(auth.getName());
			DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			tela.setFechaCreacion(hourdateFormat.toString());
			tela.setUltimaFechaModificacion(hourdateFormat.toString());
			tela.setClaveTela("Prospecto");
			tela.setDescripcionTela("Prospecto");
			tela.setLineaTela("1");
			tela.setIdUnidadMedida("1");
			tela.setConsumoPromedio("Prospecto");
			tela.setExistencia("1");
			tela.setTipo("Prospecto");
			tela.setNombreTela("prospecto");
			disenioTelaService.save(tela);
			
			
		}
		
		
		
		return "redirect:clientes";
	}
*/
	
	@PostMapping("guardar-tela")
	public String guardar_tela( DisenioTela tela,
			@RequestParam("txtTabla") String composicion,
			@RequestParam("txtTabla2") String idComposicion,
			@RequestParam(value="botones" , required=false) String botones,
			@RequestParam( value="forros" , required=false) String forros,
			@RequestParam(value="imagenTela", required=false) MultipartFile imagenTela,
			RedirectAttributes redirectAttrs) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		if ( tela.getIdTela()== null || tela.getEstatusTela().equals("0") ) {
			System.out.println("Entra if de id null y estatus tela 0 forro");
			tela.setIdFamiliaComposicion(Long.valueOf(1));
			tela.setIdCalidad(Long.valueOf(1));
			tela.setIdText("Prospecto");
			tela.setCreadoPor(auth.getName());
			if ( tela.getIdTela() == null) {
				tela.setFechaCreacion(hourdateFormat.format(date));
				redirectAttrs
	            .addFlashAttribute("title", "Tela guardada correctamente")
	            .addFlashAttribute("icon", "success");
			}
			else {
				redirectAttrs
	            .addFlashAttribute("title", "Tela editada correctamente")
	            .addFlashAttribute("icon", "success");
			}
			
			tela.setUltimaFechaModificacion(hourdateFormat.format(date));
			tela.setDescripcionTela("En evaluación");
			tela.setLineaTela("1");
			tela.setIdUnidadMedida("1");
			tela.setConsumoPromedio("1");
			tela.setExistencia("1");
			tela.setTipo("Prospecto");
			tela.setEstatus("1"); //Estatus para ver el registro en el sistema
			tela.setEstatusTela("0");// estatus para la aprobacion de la tela
			tela.setConsumo("1");
			tela.setFoto("aprueba.png");
			disenioTelaService.save(tela);
			
			disenioTelaService.borrarComposicionTela(tela.getIdTela());
			if ( composicion.length()>1) {
			String [] vect = composicion.split(",");
			String [] vect2 = idComposicion.split(",");
			for(int i= 0 ; i<vect.length -1;i++) {
				DisenioFamiliaComposicionTela fc = new DisenioFamiliaComposicionTela();
				fc.setIdFamiliaComposicion(Long.valueOf(vect2[i]));
				fc.setIdTela(tela.getIdTela());
				//fc.setEstatus(0);
				fc.setCreadoPor(auth.getName());
				fc.setActualizadoPor("null");
				fc.setFechaCreacion(hourdateFormat.format(date));
				fc.setUltimaFechaModificacion(hourdateFormat.format(date));;
				fc.setComposicion(vect[i]);
				ComposicionTelaService.save(fc);
			}
		}
		}
		else {
			disenioTelaService.borrarBotonesTela(tela.getIdTela());
			disenioTelaService.borrarComposicionTela(tela.getIdTela());
			disenioTelaService.borrarForroTela(tela.getIdTela());
			if (!imagenTela.isEmpty()){
				if ( tela.getFoto() != null && tela.getFoto().length() > 0) {

					UploadService.delete(tela.getFoto());
				}
				
				String uniqueFilename = null;
				try {
					uniqueFilename = UploadService.copyTela(imagenTela);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tela.setFoto(uniqueFilename);
			}
			
			tela.setIdFamiliaComposicion(Long.valueOf(1));
			
			
			
			tela.setIdFamiliaComposicion(Long.valueOf(1));
			 
			disenioTelaService.save(tela);
			
			if ( (forros != null) && (!forros.equals("")) ){
				String [] array = forros.split(",");
				for(int i= 0 ; i<array.length;i++) {
					DisenioTelaForro tf = new DisenioTelaForro();
					tf.setIdTela(tela.getIdTela());
					tf.setIdForro(Long.valueOf(array[i]));
					tf.setIdText("1");
					tf.setDescripcion(String.valueOf(i+1));
					tf.setCreadoPor(auth.getName());
					tf.setActualizadoPor("null");
					tf.setFechaCreacion(hourdateFormat.format(date));
					tf.setUltimaFechaModificacion(hourdateFormat.format(date));; 
					TelaForroService.save(tf);	
				}
			}
			if ( (botones != null) && (!botones.equals("")) ){
				String [] array = botones.split(",");
				for(int i= 0 ; i<array.length;i++) {
					DisenioMaterialTela tm = new DisenioMaterialTela();
					tm.setIdTela(tela.getIdTela());
					tm.setIdMaterial(Long.valueOf(array[i]));
					
					tm.setIdText("text");
					tm.setTipo(String.valueOf(i+1));
					
					MaterialService.save(tm);
				}
			}
			
			if ( composicion.length()>1) {
				String [] vect = composicion.split(",");
				String [] vect2 = idComposicion.split(",");
				for(int i= 0 ; i<vect.length -1;i++) {
					DisenioFamiliaComposicionTela fc = new DisenioFamiliaComposicionTela();
					fc.setIdFamiliaComposicion(Long.valueOf(vect2[i]));
					fc.setIdTela(tela.getIdTela());
					//fc.setEstatus(0);
					fc.setCreadoPor(auth.getName());
					fc.setActualizadoPor("null");
					fc.setFechaCreacion(hourdateFormat.format(date));
					fc.setUltimaFechaModificacion(hourdateFormat.format(date));;
					fc.setComposicion(vect[i]);
					ComposicionTelaService.save(fc);
				}
			}
			
			redirectAttrs
            .addFlashAttribute("title", "Tela editada correctamente")
            .addFlashAttribute("icon", "success");
			
		}
		return "redirect:materiales";
	}
	
	@GetMapping("editar-tela/{id}")
	public String editar(@PathVariable(value="id") Long id , Model model) {
		DisenioTela tela ;
		tela= disenioTelaService.findOne(id);
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
		
		// Comienza erik
				DisenioForro forro = new DisenioForro();
				model.addAttribute("forro", forro);
				model.addAttribute("lisFam",disenioTelaService.findAllFamilaComposicion());
				
				model.addAttribute("listForro",forroService.ForrosSelect(id)); 
				model.addAttribute("listBoton", disenioTelaService.findAllBotones(id));
				model.addAttribute("listColor", disenioTelaService.findAllColores());
				model.addAttribute("listPrendas", disenioTelaService.findAllPrenda());
				
				
			
		
		model.addAttribute("listTelaComposicon", disenioTelaService.ComposicionTelaMN(id));
		
		model.addAttribute("listBtnSelec", disenioTelaService.BonotesSeleccionados(id));
		model.addAttribute("listForroSelec", disenioTelaService.ForrosSeleccionados(id));
		model.addAttribute("tela", tela);
		
		return"agregar-material";   
	}
	
	@GetMapping(value = "/uploads/telas/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;
		try {
			recurso = UploadService.loadTela(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}
	
	@GetMapping("delete-tela/{id}") 
	public String deleteMaterial(@PathVariable("id") Long idTela, RedirectAttributes redirectAttrs) {
		DisenioTela tela = disenioTelaService.findOne(idTela);
		tela.setEstatus("0");
		disenioTelaService.save(tela);
		redirectAttrs
        .addFlashAttribute("title", "Tela elimnada correctamente")
        .addFlashAttribute("icon", "success");
		  return "redirect:materiales";
	}
}
