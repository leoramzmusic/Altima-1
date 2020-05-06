package com.altima.springboot.app.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.altima.springboot.app.models.entity.DisenioMaterial;
import com.altima.springboot.app.models.entity.DisenioMaterialPrenda;
import com.altima.springboot.app.models.entity.DisenioPrenda;
import com.altima.springboot.app.models.entity.DisenioPrendaMarcador;
import com.altima.springboot.app.models.entity.DisenioPrendaPatronaje;
import com.altima.springboot.app.models.entity.DiseñoPrendaImagen;
import com.altima.springboot.app.models.service.DisenioImagenPrendaServiceImpl;
import com.altima.springboot.app.models.service.DisenioMaterialPrendaServiceImpl;
import com.altima.springboot.app.models.service.DisenioPrendaPatronajeServiceImpl;
import com.altima.springboot.app.models.service.DisenioPrendaServiceImpl;
import com.altima.springboot.app.models.service.IDisenioLookupService;
import com.altima.springboot.app.models.service.IDisenioMaterialService;
import com.altima.springboot.app.models.service.IDisenioPrendaMarcadorService;
import com.altima.springboot.app.models.service.UploadServiceImpl;

@RestController
public class AgregarPrendaRestController {
	@Autowired
	IDisenioMaterialService disenioMaterialService;
	@Autowired
	private UploadServiceImpl uService;
	@Autowired
	private DisenioPrendaServiceImpl prendaService;
	@Autowired
	private DisenioMaterialPrendaServiceImpl materialPrendaService;
	@Autowired
	private DisenioPrendaPatronajeServiceImpl prendaPatronajeService;
	@Autowired
	private DisenioImagenPrendaServiceImpl prendaImagenService;
	@Autowired
	private IDisenioLookupService disenioLookupService;
	@Autowired
	private IDisenioPrendaMarcadorService disenioPrendaMarcadorService;
	public String file1;

	public String file2;

	public DisenioPrenda dp = new DisenioPrenda();

	@RequestMapping(value = "/detalle_material", method = RequestMethod.GET)
	public Object detalleMaterial(@RequestParam Long id) {
		Object dm = disenioMaterialService.findUno(id);

		return dm;
	}

	@RequestMapping(value = "/detalle_patronaje", method = RequestMethod.GET)
	public Object detallePatronaje(@RequestParam Long id) {
		Object dl = disenioMaterialService.findLookUp(id);
		return dl;
	}
	
	@RequestMapping(value = "/confirmar_prenda", method = RequestMethod.GET)
	public Object confirmarPrenda(@RequestParam Long id) {
		DisenioPrenda diamantePerla = prendaService.findOne(id);
		diamantePerla.setEstatusRecepcionMuestra("Definitivo");
		prendaService.save(diamantePerla);
		return diamantePerla;
	}
	
	@RequestMapping(value = "/alta_baja_prenda", method = RequestMethod.GET)
	public Object AltaBajaPrenda(@RequestParam Long id) {
		DisenioPrenda diamantePerla = prendaService.findOne(id);
		if(diamantePerla.getEstatus() == 0)
		{
			diamantePerla.setEstatus(1L);
		}
		else
		{
			diamantePerla.setEstatus(0L);
		}
		
		prendaService.save(diamantePerla);
		return diamantePerla;
	}

	@RequestMapping(value = "/guardar_prenda", method = RequestMethod.POST)
	public DisenioPrenda guardarPrenda(@RequestParam(name = "disenioprenda") String disenioprenda) {
		// Coso del auth
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		JSONObject prenda = new JSONObject(disenioprenda.toString());

		dp.setIdFamiliaPrenda(Long.valueOf((String) prenda.get("idFamiliaPrenda")));
		dp.setCreadoPor(auth.getName());
		dp.setActualizadoPor(auth.getName());
		dp.setNumeroPrenda(prenda.get("numeroPrenda").toString());
		dp.setDescripcionPrenda(prenda.get("descripcionPrenda").toString());
		dp.setTipoPrenda(prenda.get("tipoPrenda").toString());
		dp.setDetallePrenda(prenda.get("detallePrenda").toString());
		dp.setNotaEspecial(prenda.get("notaEspecial").toString());
		dp.setPrecioLocalActual(prenda.get("precioLocalActual").toString());
		dp.setPrecioLocalAnterior(prenda.get("precioLocalAnterior").toString());
		dp.setPrecioForaneoActual(prenda.get("precioForaneoActual").toString());
		dp.setPrecioForaneoAnterior(prenda.get("precioForaneoAnterior").toString());
		dp.setDetalleConfeccion(prenda.get("detalleConfeccion").toString());
		dp.setMarcadores(prenda.get("marcadores").toString());
		dp.setConsumoTela(prenda.get("consumoTela").toString());
		dp.setConsumoForro(prenda.get("consumoForro").toString());
		dp.setPrecio(prenda.get("precio").toString());
		dp.setCveRuta("1"); // Ruta predefinida siempre
		dp.setTipoLargo(prenda.get("tipoLargo").toString());
		dp.setImprimirEtiquetas(prenda.get("imprimirEtiquetas").toString());
		dp.setEstatusRecepcionMuestra("Definitivo");
		dp.setDevolucion(prenda.get("devolucion").toString());
		dp.setPrecioMprod(prenda.get("precioMprod").toString());
		dp.setPrecioMmuestra(prenda.get("precioMmuestra").toString());
		dp.setCategoria(prenda.get("categoria").toString());
		dp.setEstatus(1L);
		dp.setPrendaLocal("1");

		prendaService.save(dp);
		
		//Ides
		Long envio = Long.valueOf(prenda.get("tipoPrenda").toString());
		String[] res = prendaService.getExistencias(envio);
		dp.setIdText(res[1].toUpperCase().substring(0, 3) + (10000 + (Long.valueOf(res[0]))));
		dp.setIdTextProspecto("PROSP" + res[1].toUpperCase().substring(0, 3) + (10000 + (Long.valueOf(res[0]))));
		dp.setEstatusRecepcionMuestra("Prospecto");
		prendaService.save(dp);
		
		return dp;
	}
	
	
	@RequestMapping(value = "/editar_prenda", method = RequestMethod.POST)
	public DisenioPrenda editarPrenda(@RequestParam(name = "disenioprenda") String disenioprenda) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JSONObject prenda = new JSONObject(disenioprenda.toString());
		dp = prendaService.findOne(Long.valueOf(prenda.get("idPrenda").toString()));
		dp.setIdFamiliaPrenda(Long.valueOf((String) prenda.get("idFamiliaPrenda")));
		dp.setActualizadoPor(auth.getName());
		dp.setNumeroPrenda(prenda.get("numeroPrenda").toString());
		dp.setDescripcionPrenda(prenda.get("descripcionPrenda").toString());
		dp.setTipoPrenda(prenda.get("tipoPrenda").toString());
		dp.setDetallePrenda(prenda.get("detallePrenda").toString());
		dp.setNotaEspecial(prenda.get("notaEspecial").toString());
		dp.setPrecioLocalActual(prenda.get("precioLocalActual").toString());
		dp.setPrecioLocalAnterior(prenda.get("precioLocalAnterior").toString());
		dp.setPrecioForaneoActual(prenda.get("precioForaneoActual").toString());
		dp.setPrecioForaneoAnterior(prenda.get("precioForaneoAnterior").toString());
		dp.setDetalleConfeccion(prenda.get("detalleConfeccion").toString());
		dp.setMarcadores(prenda.get("marcadores").toString());
		dp.setConsumoTela(prenda.get("consumoTela").toString());
		dp.setConsumoForro(prenda.get("consumoForro").toString());
		dp.setPrecio(prenda.get("precio").toString());
		dp.setCveRuta("1"); // Ruta predefinida siempre
		dp.setTipoLargo(prenda.get("tipoLargo").toString());
		dp.setImprimirEtiquetas(prenda.get("imprimirEtiquetas").toString());
		dp.setEstatusRecepcionMuestra("Definitivo");
		dp.setDevolucion(prenda.get("devolucion").toString());
		dp.setPrecioMprod(prenda.get("precioMprod").toString());
		dp.setPrecioMmuestra(prenda.get("precioMmuestra").toString());
		dp.setCategoria(prenda.get("categoria").toString());
		prendaService.save(dp);
		return dp;
	}

	@RequestMapping(value = "/guardar_final", method = RequestMethod.POST)
	public void guardarFinal(@RequestParam(name = "objeto_materiales") String objeto_materiales,
			@RequestParam(name = "objeto_marcadores") String objeto_marcadores,
			@RequestParam(name = "objeto_patronajes") String objeto_patronaje,
			@RequestParam(name = "accion") String accion) throws NoSuchFieldException, SecurityException {
		
		if (accion.equalsIgnoreCase("editar")) 
		{
			disenioPrendaMarcadorService.deleteByIdPrenda(dp.getIdPrenda());
			prendaPatronajeService.deleteAllPatronajeFromPrenda(dp.getIdPrenda());
			materialPrendaService.deleteAllMaterialFromPrenda(dp.getIdPrenda());
		}

		if(!objeto_marcadores.equals(null)||objeto_marcadores.equals("")){
			for (String marcador_split : objeto_marcadores.split(",")) {
				DisenioPrendaMarcador dpm = new DisenioPrendaMarcador();
				int num1 = Integer.parseInt(marcador_split.replaceAll("^\"|\"$", ""));
				Long num = new Long(num1);
				dpm.setIdMarcador(num);
				dpm.setIdPrenda(dp.getIdPrenda());
				disenioPrendaMarcadorService.save(dpm);
			}
		}

		// Coso del auth
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// Se guardan Muchos a Muchos de Materiales
		JSONArray materiales = new JSONArray(objeto_materiales);
		for (int i = 0; i < materiales.length(); i++) {
			JSONObject material = materiales.getJSONObject(i);
			DisenioMaterialPrenda mdp = new DisenioMaterialPrenda();
			mdp.setIdMaterial(Long.valueOf(material.get("id").toString()));
			mdp.setIdPrenda(Long.valueOf(dp.getIdPrenda()));
			mdp.setCreadoPor(auth.getName());
			mdp.setActualizadoPor(auth.getName());
			mdp.setCantidad(material.get("cantidad").toString());
			materialPrendaService.save(mdp);
		}

		// Se guardan Muchos a Muchos de Patronaje
		JSONArray patronajes = new JSONArray(objeto_patronaje);
		for (int i = 0; i < patronajes.length(); i++) {
			JSONObject patronaje = patronajes.getJSONObject(i);
			DisenioPrendaPatronaje dpp = new DisenioPrendaPatronaje();
			dpp.setIdPrenda(Long.valueOf(dp.getIdPrenda()));
			dpp.setIdPatronaje(patronaje.get("id").toString());
			dpp.setCantidadTela(patronaje.get("cantidadTela").toString());
			dpp.setCantidadForro(patronaje.get("cantidadForro").toString());
			dpp.setCantidadEntretela(patronaje.get("cantidadEntretela").toString());

			prendaPatronajeService.save(dpp);
		}

		dp = null;
		this.dp = new DisenioPrenda();
	}



	@RequestMapping(value = "/prendas", method = RequestMethod.POST)
	public void guardar(HttpServletResponse response, DisenioPrenda dp, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, @RequestParam("file2") MultipartFile foto2,
			RedirectAttributes flash) throws InterruptedException, IOException {
		String[] uniqueFilename = null;
		try {
			uniqueFilename = uService.copy(foto, foto2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//this.dp.setDibujoEspalda(uniqueFilename[0]);
		//this.dp.setDibujoFrente(uniqueFilename[1]);

		Thread.sleep(2000);
		response.sendRedirect("/prendas");
	}

	@RequestMapping(value = "/prendas1", method = RequestMethod.POST)
	public void guardar1(HttpServletResponse response, DisenioPrenda dp, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash)
			throws InterruptedException, IOException {
		String uniqueFilename = null;
		try {
			uniqueFilename = uService.copy2(foto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//this.dp.setDibujoFrente(uniqueFilename);

		Thread.sleep(2000);
		response.sendRedirect("/prendas");
	}

	@RequestMapping(value = "/prendas2", method = RequestMethod.POST)
	public void guardar2(HttpServletResponse response, DisenioPrenda dp, BindingResult result, Model model,
			@RequestParam("file2") MultipartFile foto2, RedirectAttributes flash)
			throws InterruptedException, IOException {
		String uniqueFilename = null;
		try {
			uniqueFilename = uService.copy2(foto2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//this.dp.setDibujoEspalda(uniqueFilename);

		Thread.sleep(2000);
		response.sendRedirect("/prendas");
	}
	
	//Este es cuando se agrega
	@RequestMapping(value = "/imagenes_prendas", method = RequestMethod.POST)
	public void guardarImagenes(HttpServletResponse response, DisenioPrenda dp, BindingResult result, Model model, RedirectAttributes flash,
	@RequestParam("file-input-1") MultipartFile foto1, @RequestParam("name-1") String nombre1,
	@RequestParam("file-input-2") MultipartFile foto2, @RequestParam("name-2") String nombre2,
	@RequestParam("file-input-3") MultipartFile foto3, @RequestParam("name-3") String nombre3,
	@RequestParam("file-input-4") MultipartFile foto4, @RequestParam("name-4") String nombre4,
	@RequestParam("file-input-5") MultipartFile foto5, @RequestParam("name-5") String nombre5,
	@RequestParam("file-input-6") MultipartFile foto6, @RequestParam("name-6") String nombre6,
	 @RequestParam("idPrenda") String idPrenda) throws InterruptedException, IOException 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		if(nombre1.length() > 0) {
			DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
			dpi.setIdPrenda(Long.parseLong(idPrenda));
			dpi.setActualizadoPor(auth.getName());
			dpi.setCreadoPor(auth.getName());
			dpi.setEstatus("1");
			dpi.setFechaCreacion(dtf.format(now));
			dpi.setUltimaFechaModificacion(dtf.format(now));
			dpi.setNombrePrenda(nombre1);
			dpi.setRutaPrenda(uService.copy2(foto1));
			prendaImagenService.save(dpi);
		}
		
		if(nombre2.length() > 0) {
			DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
			dpi.setIdPrenda(Long.parseLong(idPrenda));
			dpi.setActualizadoPor(auth.getName());
			dpi.setCreadoPor(auth.getName());
			dpi.setEstatus("1");
			dpi.setFechaCreacion(dtf.format(now));
			dpi.setUltimaFechaModificacion(dtf.format(now));
			dpi.setNombrePrenda(nombre2);
			dpi.setRutaPrenda(uService.copy2(foto2));
			prendaImagenService.save(dpi);
		}
		
		if(nombre3.length() > 0) {
			DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
			dpi.setIdPrenda(Long.parseLong(idPrenda));
			dpi.setActualizadoPor(auth.getName());
			dpi.setCreadoPor(auth.getName());
			dpi.setEstatus("1");
			dpi.setFechaCreacion(dtf.format(now));
			dpi.setUltimaFechaModificacion(dtf.format(now));
			dpi.setNombrePrenda(nombre3);
			dpi.setRutaPrenda(uService.copy2(foto3));
			prendaImagenService.save(dpi);
		}
		
		if(nombre4.length() > 0) {
			DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
			dpi.setIdPrenda(Long.parseLong(idPrenda));
			dpi.setActualizadoPor(auth.getName());
			dpi.setCreadoPor(auth.getName());
			dpi.setEstatus("1");
			dpi.setFechaCreacion(dtf.format(now));
			dpi.setUltimaFechaModificacion(dtf.format(now));
			dpi.setNombrePrenda(nombre4);
			dpi.setRutaPrenda(uService.copy2(foto4));
			prendaImagenService.save(dpi);
		}
		
		if(nombre5.length() > 0) {
			DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
			dpi.setIdPrenda(Long.parseLong(idPrenda));
			dpi.setActualizadoPor(auth.getName());
			dpi.setCreadoPor(auth.getName());
			dpi.setEstatus("1");
			dpi.setFechaCreacion(dtf.format(now));
			dpi.setUltimaFechaModificacion(dtf.format(now));
			dpi.setNombrePrenda(nombre5);
			dpi.setRutaPrenda(uService.copy2(foto5));
			prendaImagenService.save(dpi);
		}
		
		if(nombre6.length() > 0) {
			DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
			dpi.setIdPrenda(Long.parseLong(idPrenda));
			dpi.setActualizadoPor(auth.getName());
			dpi.setCreadoPor(auth.getName());
			dpi.setEstatus("1");
			dpi.setFechaCreacion(dtf.format(now));
			dpi.setUltimaFechaModificacion(dtf.format(now));
			dpi.setNombrePrenda(nombre6);
			dpi.setRutaPrenda(uService.copy2(foto6));
			prendaImagenService.save(dpi);
		}

		
		response.sendRedirect("/prendas");
	}
	
	//Este cuando se edita
	@RequestMapping(value = "/imagenes_prendas_editar", method = RequestMethod.POST)
	public void editarImagenes(HttpServletResponse response, DisenioPrenda dp, BindingResult result, Model model, RedirectAttributes flash,
	@RequestParam("file-input-edit-1") MultipartFile foto1, @RequestParam("name-edit-1") String nombre1, @RequestParam("id-input-edit-1") String id1, @RequestParam("status-input-edit-1") String status1,
	@RequestParam("file-input-edit-2") MultipartFile foto2, @RequestParam("name-edit-2") String nombre2, @RequestParam("id-input-edit-2") String id2, @RequestParam("status-input-edit-2") String status2,
	@RequestParam("file-input-edit-3") MultipartFile foto3, @RequestParam("name-edit-3") String nombre3, @RequestParam("id-input-edit-3") String id3, @RequestParam("status-input-edit-3") String status3,
	@RequestParam("file-input-edit-4") MultipartFile foto4, @RequestParam("name-edit-4") String nombre4, @RequestParam("id-input-edit-4") String id4, @RequestParam("status-input-edit-4") String status4,
	@RequestParam("file-input-edit-5") MultipartFile foto5, @RequestParam("name-edit-5") String nombre5, @RequestParam("id-input-edit-5") String id5, @RequestParam("status-input-edit-5") String status5,
	@RequestParam("file-input-edit-6") MultipartFile foto6, @RequestParam("name-edit-6") String nombre6, @RequestParam("id-input-edit-6") String id6, @RequestParam("status-input-edit-6") String status6,
	 @RequestParam("idPrenda") String idPrenda) throws InterruptedException, IOException 
	{
		System.out.println("si llegue al editar jsjs");
		System.out.println("el id de la prenda es: " + idPrenda);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		if(!id1.isEmpty()){
			//Si existe la imagen ya.
			DiseñoPrendaImagen dpi = prendaImagenService.findOne(Long.parseLong(id1));
			if(!dpi.getNombrePrenda().equalsIgnoreCase(nombre1)){
				//Se va a cambiar el nombre de la prenda
				dpi.setNombrePrenda(nombre1);
				prendaImagenService.save(dpi);}
			if(status1.equalsIgnoreCase("Alter")){
				//Se va a cambiar la imagen
				dpi.setRutaPrenda(uService.copy2(foto1));
				prendaImagenService.save(dpi);}
			if(status1.equalsIgnoreCase("delete")){
				//Se va a borrar el registro
				prendaImagenService.delete(Long.parseLong(id1));}}
		else{
				if(!nombre1.isEmpty() && !foto1.isEmpty())
				{
					DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
					dpi.setIdPrenda(Long.parseLong(idPrenda));
					dpi.setActualizadoPor(auth.getName());
					dpi.setCreadoPor(auth.getName());
					dpi.setEstatus("1");
					dpi.setFechaCreacion(dtf.format(now));
					dpi.setUltimaFechaModificacion(dtf.format(now));
					dpi.setNombrePrenda(nombre1);
					dpi.setRutaPrenda(uService.copy2(foto1));
					prendaImagenService.save(dpi);	
				}}
		
		if(!id2.isEmpty()){
			//Si existe la imagen ya.
			DiseñoPrendaImagen dpi = prendaImagenService.findOne(Long.parseLong(id2));
			if(!dpi.getNombrePrenda().equalsIgnoreCase(nombre2)){
				//Se va a cambiar el nombre de la prenda
				dpi.setNombrePrenda(nombre2);
				prendaImagenService.save(dpi);}
			if(status2.equalsIgnoreCase("Alter")){
				//Se va a cambiar la imagen
				dpi.setRutaPrenda(uService.copy2(foto2));
				prendaImagenService.save(dpi);}
			if(status2.equalsIgnoreCase("delete")){
				//Se va a borrar el registro
				prendaImagenService.delete(Long.parseLong(id2));}}
		else{ 	
			if(!nombre2.isEmpty() && !foto2.isEmpty())
			{
				DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
				dpi.setIdPrenda(Long.parseLong(idPrenda));
				dpi.setActualizadoPor(auth.getName());
				dpi.setCreadoPor(auth.getName());
				dpi.setEstatus("1");
				dpi.setFechaCreacion(dtf.format(now));
				dpi.setUltimaFechaModificacion(dtf.format(now));
				dpi.setNombrePrenda(nombre2);
				dpi.setRutaPrenda(uService.copy2(foto2));
				prendaImagenService.save(dpi);	
			}}
		
		if(!id3.isEmpty()){
			//Si existe la imagen ya.
			DiseñoPrendaImagen dpi = prendaImagenService.findOne(Long.parseLong(id3));
			if(!dpi.getNombrePrenda().equalsIgnoreCase(nombre3)){
				//Se va a cambiar el nombre de la prenda
				dpi.setNombrePrenda(nombre3);
				prendaImagenService.save(dpi);}
			if(status3.equalsIgnoreCase("Alter")){
				//Se va a cambiar la imagen
				dpi.setRutaPrenda(uService.copy2(foto3));
				prendaImagenService.save(dpi);}
			if(status3.equalsIgnoreCase("delete")){
				//Se va a borrar el registro
				prendaImagenService.delete(Long.parseLong(id3));}}
		else{ 	
			if(!nombre3.isEmpty() && !foto3.isEmpty())
			{
				DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
				dpi.setIdPrenda(Long.parseLong(idPrenda));
				dpi.setActualizadoPor(auth.getName());
				dpi.setCreadoPor(auth.getName());
				dpi.setEstatus("1");
				dpi.setFechaCreacion(dtf.format(now));
				dpi.setUltimaFechaModificacion(dtf.format(now));
				dpi.setNombrePrenda(nombre3);
				dpi.setRutaPrenda(uService.copy2(foto3));
				prendaImagenService.save(dpi);
			}}
		
		if(!id4.isEmpty()){
			//Si existe la imagen ya.
			DiseñoPrendaImagen dpi = prendaImagenService.findOne(Long.parseLong(id4));
			if(!dpi.getNombrePrenda().equalsIgnoreCase(nombre4)){
				//Se va a cambiar el nombre de la prenda
				dpi.setNombrePrenda(nombre4);
				prendaImagenService.save(dpi);}
			if(status4.equalsIgnoreCase("Alter")){
				//Se va a cambiar la imagen
				dpi.setRutaPrenda(uService.copy2(foto4));
				prendaImagenService.save(dpi);}
			if(status4.equalsIgnoreCase("delete")){
				//Se va a borrar el registro
				prendaImagenService.delete(Long.parseLong(id4));}}
		else{ 	
			if(!nombre4.isEmpty() && !foto4.isEmpty())
			{
				DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
				dpi.setIdPrenda(Long.parseLong(idPrenda));
				dpi.setActualizadoPor(auth.getName());
				dpi.setCreadoPor(auth.getName());
				dpi.setEstatus("1");
				dpi.setFechaCreacion(dtf.format(now));
				dpi.setUltimaFechaModificacion(dtf.format(now));
				dpi.setNombrePrenda(nombre4);
				dpi.setRutaPrenda(uService.copy2(foto4));
				prendaImagenService.save(dpi);
			}}
		
		if(!id5.isEmpty()){
			//Si existe la imagen ya.
			DiseñoPrendaImagen dpi = prendaImagenService.findOne(Long.parseLong(id5));
			if(!dpi.getNombrePrenda().equalsIgnoreCase(nombre5)){
				//Se va a cambiar el nombre de la prenda
				dpi.setNombrePrenda(nombre5);
				prendaImagenService.save(dpi);}
			if(status5.equalsIgnoreCase("Alter")){
				//Se va a cambiar la imagen
				dpi.setRutaPrenda(uService.copy2(foto5));
				prendaImagenService.save(dpi);}
			if(status5.equalsIgnoreCase("delete")){
				//Se va a borrar el registro
				prendaImagenService.delete(Long.parseLong(id5));}}
		else{ 	
			if(!nombre5.isEmpty() && !foto5.isEmpty())
				{
					DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
					dpi.setIdPrenda(Long.parseLong(idPrenda));
					dpi.setActualizadoPor(auth.getName());
					dpi.setCreadoPor(auth.getName());
					dpi.setEstatus("1");
					dpi.setFechaCreacion(dtf.format(now));
					dpi.setUltimaFechaModificacion(dtf.format(now));
					dpi.setNombrePrenda(nombre5);
					dpi.setRutaPrenda(uService.copy2(foto5));
					prendaImagenService.save(dpi);	
				}}
		
		if(!id6.isEmpty()){
			//Si existe la imagen ya.
			DiseñoPrendaImagen dpi = prendaImagenService.findOne(Long.parseLong(id6));
			if(!dpi.getNombrePrenda().equalsIgnoreCase(nombre6)){
				//Se va a cambiar el nombre de la prenda
				dpi.setNombrePrenda(nombre6);
				prendaImagenService.save(dpi);}
			if(status6.equalsIgnoreCase("Alter")){
				//Se va a cambiar la imagen
				dpi.setRutaPrenda(uService.copy2(foto6));
				prendaImagenService.save(dpi);}
			if(status6.equalsIgnoreCase("delete")){
				//Se va a borrar el registro
				prendaImagenService.delete(Long.parseLong(id6));}}
		else{ 	
				if(!nombre6.isEmpty() && !foto6.isEmpty())
				{
					DiseñoPrendaImagen dpi = new DiseñoPrendaImagen();
					dpi.setIdPrenda(Long.parseLong(idPrenda));
					dpi.setActualizadoPor(auth.getName());
					dpi.setCreadoPor(auth.getName());
					dpi.setEstatus("1");
					dpi.setFechaCreacion(dtf.format(now));
					dpi.setUltimaFechaModificacion(dtf.format(now));
					dpi.setNombrePrenda(nombre6);
					dpi.setRutaPrenda(uService.copy2(foto6));
					prendaImagenService.save(dpi);	
				}}
		
		response.sendRedirect("/prendas");
	}
}
